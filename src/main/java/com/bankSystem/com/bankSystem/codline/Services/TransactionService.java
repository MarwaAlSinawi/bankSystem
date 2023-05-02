package com.bankSystem.com.bankSystem.codline.Services;

import com.bankSystem.com.bankSystem.codline.Models.Account;
import com.bankSystem.com.bankSystem.codline.Models.CreditCard;
import com.bankSystem.com.bankSystem.codline.Models.Customer;
import com.bankSystem.com.bankSystem.codline.Models.Transaction;
import com.bankSystem.com.bankSystem.codline.Repositories.AccountRepository;
import com.bankSystem.com.bankSystem.codline.Repositories.CreditCardRepository;
import com.bankSystem.com.bankSystem.codline.Repositories.CustomerRepository;
import com.bankSystem.com.bankSystem.codline.Repositories.TransactionRepository;
import com.bankSystem.com.bankSystem.codline.RequestObject.AccountRequest;
import com.bankSystem.com.bankSystem.codline.RequestObject.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    CreditCardRepository creditCardRepository;


    public void createTransaction(TransactionRequest transactionRequest) throws ParseException {
        Transaction transaction = new Transaction(); // create object
        transaction.setAmount(transactionRequest.getAmount());
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd"); // to change the format of the date
        Date convertedDateFromStringToDateFormat = dateFormatter.parse(transactionRequest.getTransactionDate());
        transaction.setTransactionDate(convertedDateFromStringToDateFormat);
        transaction.setUpdatedDate(new Date()); // give current date
        transaction.setCreatedDate(new Date());// give current date
        transaction.setIsActive(Boolean.TRUE);
        CreditCard creditCard = creditCardRepository.findById(transactionRequest.getCreditCard_Id()).get();
        transaction.setCreditCard(creditCard);
        transactionRepository.save(transaction);
    }
    public List<Transaction> getAllTransaction() {
        return transactionRepository.getAllTransaction();

    }




    public void updateTransaction(TransactionRequest transactionRequest) {
        Transaction transaction=transactionRepository.getTransactionById(transactionRequest.getId());
        transaction.setAmount(transactionRequest.getAmount());
        transaction.setTransactionDate(transactionRequest.getTransactionDate();
        transaction.setIsActive(Boolean.TRUE);
        transactionRepository.save(transaction);
    }
}

