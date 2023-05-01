package com.bankSystem.com.bankSystem.codline.Repositories;

import com.bankSystem.com.bankSystem.codline.Models.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard,Integer> {
}
