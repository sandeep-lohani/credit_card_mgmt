package com.card.credit_card_mgmt.dao;

import com.card.credit_card_mgmt.model.CreditCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<CreditCardEntity, Long> {
    CreditCardEntity findByCardNumber(String cardNo);
}
