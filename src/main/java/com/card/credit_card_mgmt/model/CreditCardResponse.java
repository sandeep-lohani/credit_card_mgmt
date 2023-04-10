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
 * CreditCardResponse
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-04T20:08:16.968088+01:00[Europe/London]")
public class CreditCardResponse {

  private String name;

  private String cardNumber;

  private String limit;

  private String balance;

  public CreditCardResponse name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name provided by the client
   * @return name
  */
  @Size(min = 1, max = 35) 
  @Schema(name = "name", example = "Test User", description = "Name provided by the client", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreditCardResponse cardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
    return this;
  }

  /**
   * Card Number for the new card
   * @return cardNumber
  */
  @Size(min = 13, max = 19) 
  @Schema(name = "cardNumber", example = "2345678934564321", description = "Card Number for the new card", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cardNumber")
  public String getCardNumber() {
    return cardNumber;
  }

  public void setCardNumber(String cardNumber) {
    this.cardNumber = cardNumber;
  }

  public CreditCardResponse limit(String limit) {
    this.limit = limit;
    return this;
  }

  /**
   * Limit of the card
   * @return limit
  */
  
  @Schema(name = "limit", example = "£22.22", description = "Limit of the card", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("limit")
  public String getLimit() {
    return limit;
  }

  public void setLimit(String limit) {
    this.limit = limit;
  }

  public CreditCardResponse balance(String balance) {
    this.balance = balance;
    return this;
  }

  /**
   * Limit of the card
   * @return balance
  */
  
  @Schema(name = "balance", example = "£100.22", description = "Limit of the card", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("balance")
  public String getBalance() {
    return balance;
  }

  public void setBalance(String balance) {
    this.balance = balance;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditCardResponse creditCardResponse = (CreditCardResponse) o;
    return Objects.equals(this.name, creditCardResponse.name) &&
        Objects.equals(this.cardNumber, creditCardResponse.cardNumber) &&
        Objects.equals(this.limit, creditCardResponse.limit) &&
        Objects.equals(this.balance, creditCardResponse.balance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, cardNumber, limit, balance);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditCardResponse {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    cardNumber: ").append(toIndentedString(cardNumber)).append("\n");
    sb.append("    limit: ").append(toIndentedString(limit)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
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

