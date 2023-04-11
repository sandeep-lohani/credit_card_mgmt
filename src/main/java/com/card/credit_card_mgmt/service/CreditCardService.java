package com.card.credit_card_mgmt.service;

import com.card.credit_card_mgmt.dao.CardRepository;
import com.card.credit_card_mgmt.model.CreditCardEntity;
import com.card.credit_card_mgmt.model.CreditCardRequest;
import com.card.credit_card_mgmt.model.CreditCardResponse;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditCardService {

    private CardRepository cardRepository;

    //This can be moved to a db table if more currencies are there.
    private static String currency = "£";

    @Autowired
    public CreditCardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public CreditCardResponse addCard(final CreditCardRequest creditCardRequest) {
        //check if card exists with same number & throw error
        if(getCard(creditCardRequest.getCardNumber()) !=null){
            return null;
        }
        CreditCardEntity creditCardEntity = cardRepository.save(new CreditCardEntity(creditCardRequest.getName(),
                creditCardRequest.getCardNumber(), 0D, creditCardRequest.getLimit()));
        CreditCardResponse creditCardResponse = new CreditCardResponse().name(creditCardEntity.getName())
                .cardNumber(creditCardEntity.getCardNumber())
                .balance(currency + creditCardEntity.getCardBalance())
                .limit(currency + creditCardEntity.getCardLimit());
        return creditCardResponse;
    }

    public List<CreditCardResponse> getCards(final Pageable pageable) {
        Page<CreditCardEntity> creditCardsPage = cardRepository.findAll(pageable);
        List<CreditCardEntity> creditCards = creditCardsPage.getContent();
        if(creditCards == null || creditCards.isEmpty()) {
            return null;
        }
        List<CreditCardResponse> response = creditCards.stream().map(cc -> new CreditCardResponse().name(cc.getName())
                .cardNumber(cc.getCardNumber())
                .balance(currency + cc.getCardBalance())
                .limit(currency + cc.getCardLimit())).collect(Collectors.toList());
        return response;
    }

    public CreditCardResponse getCard(final String creditCardNumber) {
        CreditCardEntity creditCardEntity = cardRepository.findByCardNumber(creditCardNumber);
        if(ObjectUtils.isEmpty(creditCardEntity)) {
            return null;
        }
        CreditCardResponse creditCardResponse = new CreditCardResponse().name(creditCardEntity.getName())
                .cardNumber(creditCardEntity.getCardNumber())
                .balance(currency + creditCardEntity.getCardBalance())
                .limit(currency + creditCardEntity.getCardLimit());
        return creditCardResponse;
    }

}
