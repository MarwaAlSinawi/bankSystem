package com.bankSystem.com.bankSystem.codline.Repositories;

import com.bankSystem.com.bankSystem.codline.Models.Account;
import com.bankSystem.com.bankSystem.codline.Models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {

    @Query("SELECT a from Account a")
    List<Account> getAllAccount();

    @Query("SELECT a from Account a where a.id= :AccountId")
        // :id is coming from the user
    Account getAccountById(@Param("AccountId") Integer id);

    @Query(value="SELECT a.balance from Account a where a.id = :id")
    Double getBalance(@Param("id") Integer id);


    @Query(value = " select id from account where account_number=:accountNumber",nativeQuery = true)
    Integer getAccountByAccountNumber(@Param("accountNumber") Integer accountNumber);


    @Query(value = "Select a From Account a WHERE a.customer.id = :id")
    List<Account> getCustomerAccountInformation(@Param("id") Integer customerId);

    @Query(value = "Select a.balance From Account a WHERE a.id = :id")
    Double getBalanceForAccount(@Param("id") Integer id);


}
