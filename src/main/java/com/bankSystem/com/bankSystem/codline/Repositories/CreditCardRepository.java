package com.bankSystem.com.bankSystem.codline.Repositories;

import com.bankSystem.com.bankSystem.codline.Models.Account;
import com.bankSystem.com.bankSystem.codline.Models.CreditCard;
import com.bankSystem.com.bankSystem.codline.Models.Customer;
import com.bankSystem.com.bankSystem.codline.Models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard,Integer> {
    @Query("SELECT c from CreditCard c where c.id= :creditCard_Id")
    CreditCard getCreditCardById(@Param("creditCard_Id") Integer id);

    @Query("SELECT c from CreditCard c")
    List<CreditCard> getAllCreditCard();

    @Query("SELECT c from CreditCard c where c.id= :CreditCardId")
        // :id is coming from the user
    CreditCard getCreditCardByID(@Param("CreditCardId") Integer id);
}
