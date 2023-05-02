//package com.bankSystem.com.bankSystem.codline.Controlles;
//
//import com.bankSystem.com.bankSystem.codline.Services.AccountService;
//import com.bankSystem.com.bankSystem.codline.Services.TransactionService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Date;
//
//@RestController
//@RequestMapping(value = "Transaction")
//public class TransactionController {
//    @Autowired
//    TransactionService transactionService;
//    @RequestMapping(value = "/createTransactions", method = RequestMethod.POST)
//    public String createAccount(@RequestParam Integer accountNumber, Double balance, Integer customerID) {
//        try {
//            transactionService.createTransaction(accountNumber, balance, customerID);
//        } catch (Exception e) {
//            return "Failed try again";
//        }
//        return "Account Created Successfully :)";
//    }
//
//}
