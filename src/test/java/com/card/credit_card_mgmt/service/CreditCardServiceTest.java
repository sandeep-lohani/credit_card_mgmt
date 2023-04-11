package com.card.credit_card_mgmt.service;

import com.card.credit_card_mgmt.dao.CardRepository;
import com.card.credit_card_mgmt.model.CreditCardEntity;
import com.card.credit_card_mgmt.model.CreditCardResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.any;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class CreditCardServiceTest {

    @InjectMocks
    private CreditCardService creditCardService;

    @Mock
    private CardRepository cardRepository;

    @Test
    void getCards() {
        when(cardRepository.findAll(any(Pageable.class))).thenReturn(
                new PageImpl(Arrays.asList(new CreditCardEntity("john", "2222420000001113", 100D, 20D))));
        List<CreditCardResponse> creditCards = creditCardService.getCards(
                PageRequest.of(0, 3, Sort.by("name").descending()));
        assertEquals(1, creditCards.size());
        assertEquals("2222420000001113", creditCards.get(0).getCardNumber());
    }
}