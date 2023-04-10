package com.card.credit_card_mgmt.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import org.springframework.format.annotation.DateTimeFormat;

import javax.annotation.Generated;
import javax.validation.Valid;
import java.util.Date;
import java.util.Objects;

/**
 * ErrorDetails
 */

@Builder
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-04-04T20:08:16.968088+01:00[Europe/London]")
public class ErrorDetails {

  private String message;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private Date timestamp;

  private String details;

  public ErrorDetails message(String message) {
    this.message = message;
    return this;
  }

  /**
   * A brief message of what error has occurred
   * @return message
  */
  
  @Schema(name = "message", description = "A brief message of what error has occurred", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorDetails timestamp(Date timestamp) {
    this.timestamp = timestamp;
    return this;
  }

  /**
   * timestamp when this error was recorded
   * @return timestamp
  */
  @Valid 
  @Schema(name = "timestamp", description = "timestamp when this error was recorded", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("timestamp")
  public Date getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Date timestamp) {
    this.timestamp = timestamp;
  }

  public ErrorDetails details(String details) {
    this.details = details;
    return this;
  }

  /**
   * Where appropriate, indicates detailed information about data received and calculated during request processing, to help the user with diagnosing errors.
   * @return details
  */
  
  @Schema(name = "details", description = "Where appropriate, indicates detailed information about data received and calculated during request processing, to help the user with diagnosing errors.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("details")
  public String getDetails() {
    return details;
  }

  public void setDetails(String details) {
    this.details = details;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorDetails errorDetails = (ErrorDetails) o;
    return Objects.equals(this.message, errorDetails.message) &&
        Objects.equals(this.timestamp, errorDetails.timestamp) &&
        Objects.equals(this.details, errorDetails.details);
  }

  @Override
  public int hashCode() {
    return Objects.hash(message, timestamp, details);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{\n");
    sb.append("    \"message\": \"").append(toIndentedString(message)).append("\", \n");
    sb.append("    \"timestamp\": \"").append(toIndentedString(timestamp)).append("\", \n");
    sb.append("    \"details\": \"").append(toIndentedString(details)).append("\" \n");
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

