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

}
