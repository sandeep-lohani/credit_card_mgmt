package com.card.credit_card_mgmt.dao;

import com.card.credit_card_mgmt.model.CreditCardEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends PagingAndSortingRepository<CreditCardEntity, Long> {
    CreditCardEntity findByCardNumber(String cardNo);
}
