package com.card.credit_card_mgmt.dao;


import com.card.credit_card_mgmt.model.CreditCardEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class CardRepositoryTest {

    @Autowired
    private CardRepository cardRepository;

    @Test
    public void givenCardRepository_whenSaveCreditCardEntity_thenOK() {
        CreditCardEntity cardEntity1 = cardRepository
                .save(new CreditCardEntity("john", "2222420000001113", 100D, 20D));
        Optional<CreditCardEntity> foundEntity = cardRepository.findById(cardEntity1.getId());
        assertEquals(true, foundEntity.isPresent());
        assertNotNull(foundEntity.get());
        assertEquals(cardEntity1.getCardNumber(), foundEntity.get().getCardNumber());
    }

    @Test
    public void givenCardRepository_whenFetchCreditCardEntity_thenOK() {
        CreditCardEntity foundEntity = cardRepository.findByCardNumber("2222420000001113");
        assertNotNull(foundEntity);
    }

    @Test
    public void givenCardRepository_whenFetchAllCreditCardEntity_thenOK() {
        Page<CreditCardEntity> foundEntities = cardRepository.findAll(
                PageRequest.of(0, 3, Sort.by("name").descending()));
        assertNotNull(foundEntities.getContent());
        assertEquals(1, foundEntities.getContent().size());
    }
}