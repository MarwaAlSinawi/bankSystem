package com.bankSystem.com.bankSystem.codline.Services;

import com.bankSystem.com.bankSystem.codline.Models.Account;
import com.bankSystem.com.bankSystem.codline.Models.Customer;
import com.bankSystem.com.bankSystem.codline.Repositories.AccountRepository;
import com.bankSystem.com.bankSystem.codline.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    public  void createAccount( Double balance, Integer AccountNumber) {
       Account account = new Account();
        account.setBalance(balance);
        account.setAccountNumber(AccountNumber);
        account.setCreatedDate(new Date()); //
        account.setUpdatedDate(new Date()); //
        account.setIsActive(Boolean.TRUE);
        accountRepository.save(account);

    }
}
