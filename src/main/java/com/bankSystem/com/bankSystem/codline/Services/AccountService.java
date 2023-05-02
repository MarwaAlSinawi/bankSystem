package com.bankSystem.com.bankSystem.codline.Services;

import com.bankSystem.com.bankSystem.codline.Models.Account;
import com.bankSystem.com.bankSystem.codline.Models.Customer;
import com.bankSystem.com.bankSystem.codline.Repositories.AccountRepository;
import com.bankSystem.com.bankSystem.codline.Repositories.CustomerRepository;
import com.bankSystem.com.bankSystem.codline.RequestObject.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CustomerRepository customerRepository;
    public  void createAccount( AccountRequest accountRequest) {
       Account accounts = new Account();
        accounts.setBalance(accountRequest.getBalance());
        accounts.setAccountNumber(accountRequest.getAccountNumber());
        accounts.setCreatedDate(new Date()); //
        accounts.setUpdatedDate(new Date()); //
        accounts.setIsActive(Boolean.TRUE);
        Customer customer =customerRepository.getCustomerById(accountRequest.getCustomerId());
        accounts.setCustomer(customer);
        accountRepository.save(accounts);

    }
}
