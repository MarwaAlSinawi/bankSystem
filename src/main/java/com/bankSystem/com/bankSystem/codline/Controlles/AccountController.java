package com.bankSystem.com.bankSystem.codline.Controlles;

import com.bankSystem.com.bankSystem.codline.Models.Account;
import com.bankSystem.com.bankSystem.codline.Repositories.AccountRepository;
import com.bankSystem.com.bankSystem.codline.RequestObject.AccountRequest;
import com.bankSystem.com.bankSystem.codline.RequestObject.CreditCardRequest;
import com.bankSystem.com.bankSystem.codline.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "Account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @RequestMapping(value = "/createAccount" , method = RequestMethod.POST)
    public String createAccount (AccountRequest accountRequest) {
        accountService.createAccount(accountRequest);
        return "Account Created Successfuly";
    }
    @RequestMapping(value = "/getAllAccount", method = RequestMethod.GET)
    //function that returns all Accounts
    public List<Account> getAllAccount() {
        AccountRepository accountRepository;
        List<Account> accounts = accountService.getAllAccount();

        return accounts;
    }
    @RequestMapping(value = "/updateAccountById", method = RequestMethod.POST)
    public String updateAccountById(AccountRequest accountRequest) {
        try {
            accountService.updateAccount(accountRequest);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Account update Successfully :)";
    }

    @RequestMapping(value = "/deleteAccountById", method = RequestMethod.POST)
    public String deleteAccountById(AccountRequest accountRequest) {
        try {
            accountService.deleteAccountById(accountRequest);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Account deleted Successfully :)";
    }@GetMapping("/accountStatement")
    public ResponseEntity<String> generateMonthlyStatementForAccount(@RequestParam Integer accountId) {
        String statement = accountService.generateMonthlyStatement(accountId);
        return ResponseEntity.ok(statement);
    }

    }
