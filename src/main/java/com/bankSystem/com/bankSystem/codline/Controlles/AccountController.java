package com.bankSystem.com.bankSystem.codline.Controlles;

import com.bankSystem.com.bankSystem.codline.Models.Account;
import com.bankSystem.com.bankSystem.codline.Repositories.AccountRepository;
import com.bankSystem.com.bankSystem.codline.RequestObject.AccountRequest;
import com.bankSystem.com.bankSystem.codline.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
