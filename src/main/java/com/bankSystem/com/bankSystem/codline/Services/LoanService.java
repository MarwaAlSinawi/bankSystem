package com.bankSystem.com.bankSystem.codline.Services;

import com.bankSystem.com.bankSystem.codline.Models.Customer;
import com.bankSystem.com.bankSystem.codline.Models.Loan;
import com.bankSystem.com.bankSystem.codline.Repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class LoanService {
    @Autowired
    LoanRepository loanRepository;
    public  void createLoan(Double Amount, Double InsertRate) {
        Loan loan = new Loan();
        loan.setAmount(Amount);
        loan.setInsertRate(InsertRate);
        loan.setCreatedDate(new Date()); //
        loan.setUpdatedDate(new Date()); //
        loan.setIsActive(Boolean.TRUE);
        loanRepository.save(loan);
    }
}
