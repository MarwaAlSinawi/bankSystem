package com.bankSystem.com.bankSystem.codline.Controlles;

import com.bankSystem.com.bankSystem.codline.Models.Loan;
import com.bankSystem.com.bankSystem.codline.Models.Transaction;
import com.bankSystem.com.bankSystem.codline.Repositories.LoanRepository;
import com.bankSystem.com.bankSystem.codline.RequestObject.AccountRequest;
import com.bankSystem.com.bankSystem.codline.RequestObject.TransactionRequest;
import com.bankSystem.com.bankSystem.codline.Services.AccountService;
import com.bankSystem.com.bankSystem.codline.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "Transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @RequestMapping(value = "/createTransactions", method = RequestMethod.POST)
    public String createTransaction(TransactionRequest transactionRequest) {
        try {
            transactionService.createTransaction(transactionRequest);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Account Created Successfully :)";
    }
    @RequestMapping(value = "/getAllTransaction", method = RequestMethod.GET)
    //function that returns all Transaction
    public List<Transaction> getAllTransaction() {
        LoanRepository loanRepository;
        List<Transaction> Transactions=transactionService.getAllTransaction();
        return Transactions;
    }
    @RequestMapping(value = "/updateTransaction", method = RequestMethod.POST)
    public String updateTransaction(TransactionRequest transactionRequest) {
        try {
            transactionService.updateTransaction( transactionRequest);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Transaction update Successfully :)";
    } @RequestMapping(value = "/deleteTransactionById", method = RequestMethod.POST)
    public String deleteTransactionById(TransactionRequest transactionRequest) {
        try {
            transactionService.deleteTransactionById(transactionRequest);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Transaction deleted Successfully :)";


    } @RequestMapping(value = "makeTransaction", method = RequestMethod.GET)
    public String makeTransaction(@RequestBody TransactionRequest transactionRequest) {
        try {
            transactionService.createTransaction(transactionRequest);
            return "Transaction made Successfully";
        } catch (Exception e) {
            return "Transaction Failed";
        }
    }


}
