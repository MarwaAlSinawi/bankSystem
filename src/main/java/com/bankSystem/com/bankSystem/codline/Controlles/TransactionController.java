package com.bankSystem.com.bankSystem.codline.Controlles;

import com.bankSystem.com.bankSystem.codline.Services.AccountService;
import com.bankSystem.com.bankSystem.codline.Services.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "Transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;
    @RequestMapping(value = "/createTransaction")
    public void createTransaction ( Double Amount ,Date TransactionDate) {
        transactionService.createTransaction( Amount , TransactionDate);
    }

}
