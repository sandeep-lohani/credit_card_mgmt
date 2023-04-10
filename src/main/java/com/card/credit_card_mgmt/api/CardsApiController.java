package com.card.credit_card_mgmt.api;

import com.card.credit_card_mgmt.model.CreditCardRequest;
import com.card.credit_card_mgmt.model.CreditCardResponse;
import com.card.credit_card_mgmt.model.ErrorDetails;
import com.card.credit_card_mgmt.model.ErrorMessage;
import com.card.credit_card_mgmt.service.CreditCardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.NativeWebRequest;

import javax.annotation.Generated;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Optional;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-04T20:08:16.968088+01:00[Europe/London]")
@Controller
@RequestMapping("${openapi.creditCardManagement.base-path:}")
@Slf4j
public class CardsApiController implements CardsApi {

    private final NativeWebRequest request;
    private CreditCardService creditCardService;

    @Autowired
    public CardsApiController(NativeWebRequest request, CreditCardService creditCardService) {
        this.request = request;
        this.creditCardService = creditCardService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    @Operation(
            operationId = "addCreditCard",
            summary = "Credit Card addition",
            tags = { "Credit Card Management" },
            responses = {
                    @ApiResponse(responseCode = "201", description = "Successful response", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = CreditCardResponse.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))
                    }),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorDetails.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/cards/credit-card",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<CreditCardResponse> addCreditCard(
            @Parameter(name = "creditCardRequest", description = "creditCardRequest", required = true) @Valid @RequestBody CreditCardRequest creditCardRequest
    ) {
        try {
            if(!ApiUtil.validateCardNumber(creditCardRequest.getCardNumber())) {
                log.error(ErrorMessage.INVALID_CARD.getMessage() + creditCardRequest.getCardNumber()); //TODO card should be masked before logging
                ApiUtil.setErrorResponse(request, "application/json", ErrorMessage.INVALID_CARD);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }

            CreditCardResponse creditCardResponse = creditCardService.addCard(creditCardRequest);
            if(creditCardResponse == null) {
                log.error(ErrorMessage.DUPLICATE_CARD.getMessage() + creditCardRequest.getCardNumber()); //TODO card should be masked before logging
                ApiUtil.setErrorResponse(request, "application/json", ErrorMessage.DUPLICATE_CARD);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            log.debug("Credit card details added successfully : {}", creditCardResponse);
            return new ResponseEntity<>(creditCardResponse, HttpStatus.CREATED);
        } catch (RuntimeException re) {
            log.error(ErrorMessage.TECHNICAL_ERROR.getMessage());
            ApiUtil.setErrorResponse(request, "application/json", ErrorMessage.TECHNICAL_ERROR);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            log.error(ErrorMessage.FATAL_ERROR.getMessage());
            ApiUtil.setErrorResponse(request, "application/json", ErrorMessage.FATAL_ERROR);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Operation(
            operationId = "getCreditCards",
            summary = "Retreives all credit cards",
            tags = { "Credit Card Management" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful response", content = {
                            @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = CreditCardResponse.class)))
                    }),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/cards/credit-cards",
            produces = { "application/json" }
    )
    public ResponseEntity<List<CreditCardResponse>> getCreditCards(
            @ParameterObject final Pageable pageable
    ) {
        try {
            List<CreditCardResponse> creditCardResponse = creditCardService.getCards();
            if(creditCardResponse == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            log.debug("Credit card details retrieved successfully : {}", creditCardResponse);
            return new ResponseEntity<>(creditCardResponse, HttpStatus.OK);
        } catch (RuntimeException re) {
            log.error(ErrorMessage.TECHNICAL_ERROR.getMessage());
            ApiUtil.setErrorResponse(request, "application/json", ErrorMessage.TECHNICAL_ERROR);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            log.error(ErrorMessage.FATAL_ERROR.getMessage());
            ApiUtil.setErrorResponse(request, "application/json", ErrorMessage.FATAL_ERROR);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    @Operation(
            operationId = "getCreditCard",
            summary = "Retrieve credit card",
            tags = { "Credit Card Management" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "Successful response", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = CreditCardResponse.class))
                    }),
                    @ApiResponse(responseCode = "400", description = "Bad Request"),
                    @ApiResponse(responseCode = "404", description = "Not Found"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/cards/credit-card",
            produces = { "application/json" }
    )
    public ResponseEntity<CreditCardResponse> getCreditCard(
            @NotNull @Size(min = 13, max = 19) @Parameter(name = "creditCardNumber", description = "Card Number", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "creditCardNumber", required = true) String creditCardNumber
    ) {
        try {
            if(!ApiUtil.validateCardNumber(creditCardNumber)) {
                log.error(ErrorMessage.INVALID_CARD.getMessage() + creditCardNumber); //TODO card should be masked before logging
                ApiUtil.setErrorResponse(request, "application/json", ErrorMessage.INVALID_CARD);
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            CreditCardResponse creditCardResponse = creditCardService.getCard(creditCardNumber);
            if(creditCardResponse == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            log.debug("Credit card details retrieved successfully : {}", creditCardResponse);
            return new ResponseEntity<>(creditCardResponse, HttpStatus.OK);
        } catch (RuntimeException re) {
            log.error(ErrorMessage.TECHNICAL_ERROR.getMessage());
            ApiUtil.setErrorResponse(request, "application/json", ErrorMessage.TECHNICAL_ERROR);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (Exception e) {
            log.error(ErrorMessage.FATAL_ERROR.getMessage());
            ApiUtil.setErrorResponse(request, "application/json", ErrorMessage.FATAL_ERROR);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
