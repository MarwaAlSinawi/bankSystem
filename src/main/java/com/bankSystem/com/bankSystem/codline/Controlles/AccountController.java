package com.bankSystem.com.bankSystem.codline.Controlles;

import com.bankSystem.com.bankSystem.codline.Services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Account")
public class AccountController {
    @Autowired
    AccountService accountService;
    @RequestMapping(value = "/createAccount")
    public void createAccount ( Double balance, Integer AccountNumber) {
        accountService.createAccount( balance, AccountNumber);
    }

}
