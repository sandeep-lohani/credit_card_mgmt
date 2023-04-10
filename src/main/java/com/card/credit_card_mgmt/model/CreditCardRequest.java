package com.card.credit_card_mgmt.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * CreditCardRequest
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-04T20:08:16.968088+01:00[Europe/London]")
public class CreditCardRequest {

  private String name;

  private String cardNumber;

  private Double limit;

  /**
   * Default constructor
   * @deprecated Use {@link CreditCardRequest#CreditCardRequest(String, String, Double)}
   */
  @Deprecated
  public CreditCardRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreditCardRequest(String name, String cardNumber, Double limit) {
    this.name = name;
    this.cardNumber = cardNumber;
    this.limit = limit;
  }

  public CreditCardRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name provided by the client
   * @return name
  */
  @NotNull @Size(min = 1, max = 35) 
  @Schema(name = "name", example = "Test user", description = "Name provided by the client", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreditCardRequest cardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
    return this;
  }

  /**
   * Card Number for the new card
   * @return cardNumber
  */
  @NotNull @Pattern(regexp = "^[0-9]{13,19}$") @Size(min = 13, max = 19) 
  @Schema(name = "cardNumber", example = "2345678934564321", description = "Card Number for the new card", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("cardNumber")
  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public CreditCardRequest limit(Double limit) {
    this.limit = limit;
    return this;
  }

  /**
   * Limit of the card
   * @return limit
  */
  @NotNull 
  @Schema(name = "limit", example = "22.22", description = "Limit of the card", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("limit")
  public Double getLimit() {
    return limit;
  }

  public void setLimit(Double limit) {
    this.limit = limit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditCardRequest creditCardRequest = (CreditCardRequest) o;
    return Objects.equals(this.name, creditCardRequest.name) &&
        Objects.equals(this.cardNumber, creditCardRequest.cardNumber) &&
        Objects.equals(this.limit, creditCardRequest.limit);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, cardNumber, limit);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditCardRequest {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

