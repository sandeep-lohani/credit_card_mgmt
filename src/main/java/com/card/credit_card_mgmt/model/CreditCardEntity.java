package com.card.credit_card_mgmt.model;

import javax.persistence.*;

@Entity
@Table(name = "card_details")
public class CreditCardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_balance")
    private Double cardBalance;

    @Column(name = "card_limit")
    private Double cardLimit;

    public CreditCardEntity() {
    }

    public CreditCardEntity(String name, String cardNumber, Double cardBalance, Double cardLimit) {
        this.name = name;
        this.cardNumber = cardNumber;
        this.cardBalance = cardBalance;
        this.cardLimit = cardLimit;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Double getCardBalance() {
        return cardBalance;
    }

    public void setCardBalance(Double cardBalance) {
        this.cardBalance = cardBalance;
    }

    public Double getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(Double cardLimit) {
        this.cardLimit = cardLimit;
    }

    @Override
    public String toString() {
        return "CreditCardEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cardBalance=" + cardBalance +
                ", cardLimit=" + cardLimit +
                '}';
    }
}
