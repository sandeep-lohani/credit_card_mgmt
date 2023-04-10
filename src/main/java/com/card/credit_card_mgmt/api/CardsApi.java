/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.5.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.card.credit_card_mgmt.api;

import com.card.credit_card_mgmt.model.CreditCardRequest;
import com.card.credit_card_mgmt.model.CreditCardResponse;
import com.card.credit_card_mgmt.model.ErrorDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
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

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-08T11:34:48.324403+01:00[Europe/London]")
@Validated
@Tag(name = "Credit Card Management", description = "the Credit Card Management API")
public interface CardsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /cards/credit-card : Credit Card addition
     *
     * @param creditCardRequest creditCardRequest (required)
     * @return Successful response (status code 201)
     *         or Bad Request (status code 400)
     *         or Internal Server Error (status code 500)
     */
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
    default ResponseEntity<CreditCardResponse> addCreditCard(
            @Parameter(name = "creditCardRequest", description = "creditCardRequest", required = true) @Valid @RequestBody CreditCardRequest creditCardRequest
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"balance\" : \"£100.22\", \"name\" : \"Test User\", \"limit\" : \"£22.22\", \"cardNumber\" : \"2345678934564321\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /cards/credit-card : Retrieve credit card
     *
     * @param creditCardNumber Card Number (required)
     * @return Successful response (status code 200)
     *         or Bad Request (status code 400)
     *         or Not Found (status code 404)
     *         or Internal Server Error (status code 500)
     */
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
    default ResponseEntity<CreditCardResponse> getCreditCard(
            @NotNull @Size(min = 13, max = 19) @Parameter(name = "creditCardNumber", description = "Card Number", required = true, in = ParameterIn.QUERY) @Valid @RequestParam(value = "creditCardNumber", required = true) String creditCardNumber
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"balance\" : \"£100.22\", \"name\" : \"Test User\", \"limit\" : \"£22.22\", \"cardNumber\" : \"2345678934564321\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /cards/credit-cards : Retreives all credit cards
     *
     * @return Successful response (status code 200)
     *         or Bad Request (status code 400)
     *         or Not Found (status code 404)
     *         or Internal Server Error (status code 500)
     */
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
    default ResponseEntity<List<CreditCardResponse>> getCreditCards(
            @ParameterObject final Pageable pageable
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"balance\" : \"£100.22\", \"name\" : \"Test User\", \"limit\" : \"£22.22\", \"cardNumber\" : \"2345678934564321\" }, { \"balance\" : \"£100.22\", \"name\" : \"Test User\", \"limit\" : \"£22.22\", \"cardNumber\" : \"2345678934564321\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}