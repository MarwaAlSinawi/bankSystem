package com.bankSystem.com.bankSystem.codline.Services;

import com.bankSystem.com.bankSystem.codline.Models.Customer;
import com.bankSystem.com.bankSystem.codline.Models.Loan;
import com.bankSystem.com.bankSystem.codline.Repositories.CustomerRepository;
import com.bankSystem.com.bankSystem.codline.Repositories.LoanRepository;
import com.bankSystem.com.bankSystem.codline.RequestObject.LoanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoanService {
    @Autowired
    LoanRepository loanRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public void createLoan(LoanRequest loanRequest) {
        Loan loan = new Loan(); // create object
        loan.setAmount(loanRequest.getAmount());
        loan.setInsertRate(loanRequest.getInsertRate());
        loan.setUpdatedDate(new Date()); // give current date
        loan.setCreatedDate(new Date());// give current date
        loan.setIsActive(Boolean.TRUE);
        Customer customer = customerRepository.findById(loanRequest.getCustomer_Id()).get();
        loan.setCustomer(customer);
        loanRepository.save(loan);
    }
}
