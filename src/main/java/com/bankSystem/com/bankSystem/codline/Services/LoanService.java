package com.bankSystem.com.bankSystem.codline.Services;

import com.bankSystem.com.bankSystem.codline.Models.CreditCard;
import com.bankSystem.com.bankSystem.codline.Models.Customer;
import com.bankSystem.com.bankSystem.codline.Models.Loan;
import com.bankSystem.com.bankSystem.codline.Models.Transaction;
import com.bankSystem.com.bankSystem.codline.Repositories.CustomerRepository;
import com.bankSystem.com.bankSystem.codline.Repositories.LoanRepository;
import com.bankSystem.com.bankSystem.codline.RequestObject.CreditCardRequest;
import com.bankSystem.com.bankSystem.codline.RequestObject.LoanRequest;
import com.bankSystem.com.bankSystem.codline.RequestObject.TransactionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
    public List<Loan> getAllLoan() {
        return  loanRepository.getAllLoan();


    }  public void updateLoan(LoanRequest loanRequest)throws ParseException {
        Loan loan=loanRepository.getLoanById(loanRequest.getId());
        loan.setAmount(loanRequest.getAmount());
        loan.setInsertRate(loanRequest.getInsertRate());
        loan.setIsActive(Boolean.TRUE);
        loanRepository.save(loan);
    }
    public void deleteLoanById(LoanRequest loanRequest) {
        Loan loan=loanRepository.getLoanById(loanRequest.getId());
        loan.setIsActive(Boolean.FALSE);
        loanRepository.save(loan);

    }
}
