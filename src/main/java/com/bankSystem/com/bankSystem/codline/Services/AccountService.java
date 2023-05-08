package com.bankSystem.com.bankSystem.codline.Services;

import com.bankSystem.com.bankSystem.codline.Models.Account;
import com.bankSystem.com.bankSystem.codline.Models.Customer;
import com.bankSystem.com.bankSystem.codline.Models.Transaction;
import com.bankSystem.com.bankSystem.codline.Repositories.AccountRepository;
import com.bankSystem.com.bankSystem.codline.Repositories.CustomerRepository;
import com.bankSystem.com.bankSystem.codline.Repositories.TransactionRepository;
import com.bankSystem.com.bankSystem.codline.RequestObject.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    TransactionRepository transactionRepository;

    public void createAccount(AccountRequest accountRequest) {
        Account accounts = new Account();
        accounts.setBalance(accountRequest.getBalance());
        accounts.setAccountNumber(accountRequest.getAccountNumber());
        accounts.setCreatedDate(new Date()); //
        accounts.setUpdatedDate(new Date()); //
        accounts.setIsActive(Boolean.TRUE);
        Customer customer = customerRepository.getCustomerById(accountRequest.getCustomerId());
        accounts.setCustomer(customer);
        accountRepository.save(accounts);

    }

    public List<Account> getAllAccount() {
        return accountRepository.getAllAccount();

    }

    public void updateAccount(AccountRequest accountRequest) throws ParseException {
        Account account = accountRepository.getAccountById(accountRequest.getId());
        account.setActive(Boolean.TRUE);
        account.setAccountNumber(accountRequest.getAccountNumber());
        account.setBalance(accountRequest.getBalance());
        accountRepository.save(account);


    }

    public void deleteAccountById(AccountRequest accountRequest) {
        Account account = accountRepository.getAccountById(accountRequest.getId());
        account.setIsActive(Boolean.FALSE);
        accountRepository.save(account);


    }

    public String generateMonthlyStatement(Integer accountId) {
        Account account = accountRepository.getAccountById(accountId);
        Customer customer = account.getCustomer();
        LocalDate currentDate = LocalDate.now();
        LocalDate statementDate = LocalDate.of(currentDate.getYear(), currentDate.getMonth(), 1);

        String statementForAccount = "Monthly Statement for Account: " + account.getAccountNumber() + "\n" +
                "Customer Name: " + customer.getName() + "\n" +
                "Month: " + statementDate.getMonth().toString() + " " + statementDate.getYear() + "\n" +
                "Customer Email: " + customer.getEmail() + "\n" +
                "Customer Phone: " + customer.getPhone() + "\n" +
                "Account Balance: " + account.getBalance() + "\n";

        return statementForAccount;
    }

    public Double getTransactionsAmountByAccountId(Integer id) {
        Double transaction = transactionRepository.getTransactionsAmountByAccountId(id);
        return transaction;
    }

    public Double UpdateTheBalanceAfterTransactions(Integer id) {
        List<Account> accountList = accountRepository.getAllAccount();
        for (Account account : accountList) {
            Double transactionalAmount = transactionRepository.getTransactionsAmountByAccountId(id);
            Double AccountBalance = account.getBalance();
            Double newBalance = AccountBalance - transactionalAmount;
            account.setBalance(newBalance);
            accountRepository.save(account);


        }
        return accountRepository.getBalance(id);


    }

    public List<Transaction> getAccountHistory(Integer accountId) {
        Account account = accountRepository.findById(accountId).get();
        List<Transaction> transactions = transactionRepository.getAllByAccount(account);
        return transactions;

    }
}
