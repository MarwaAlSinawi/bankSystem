package com.bankSystem.com.bankSystem.codline.Repositories;

import com.bankSystem.com.bankSystem.codline.Models.Account;
import com.bankSystem.com.bankSystem.codline.Models.Loan;
import com.bankSystem.com.bankSystem.codline.Models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
    List<Transaction> getAllByAccount(Account account);

    @Query("SELECT t from Transaction t")
    List<Transaction> getAllTransaction();

    @Query("SELECT t from Transaction t where t.id= :transactionId")
        // :id is coming from the user
    Transaction getTransactionById(@Param("transactionId") Integer id);

    @Query(value = "select amount from account_transaction where credit_card_id=:id " , nativeQuery = true)
    Double getTransactionsAmountByAccountId(@Param("id") Integer id);






}
