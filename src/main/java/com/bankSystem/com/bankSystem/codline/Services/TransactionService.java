package com.bankSystem.com.bankSystem.codline.Services;

import com.bankSystem.com.bankSystem.codline.Models.Account;
import com.bankSystem.com.bankSystem.codline.Models.Transaction;
import com.bankSystem.com.bankSystem.codline.Repositories.AccountRepository;
import com.bankSystem.com.bankSystem.codline.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    public  void createTransaction( Double Amount ,Date TransactionDate) {
        Transaction  transaction = new Transaction();
        transaction.setAmount(Amount);
        transaction.setTransactionDate(TransactionDate);
        transaction.setCreatedDate(new Date()); //
        transaction.setUpdatedDate(new Date()); //
        transaction.setIsActive(Boolean.TRUE);
        transactionRepository.save(transaction);

    }
}
