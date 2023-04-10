package com.card.credit_card_mgmt.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorMessage {
    INVALID_CARD("Invalid card number "),
    DUPLICATE_CARD("Card already exists "),
    FATAL_ERROR("FATAL_ERROR"),
    TECHNICAL_ERROR("TECHNICAL_ERROR");

    private String message;
}
