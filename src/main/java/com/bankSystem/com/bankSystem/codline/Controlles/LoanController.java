package com.bankSystem.com.bankSystem.codline.Controlles;

import com.bankSystem.com.bankSystem.codline.Services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "Loan")
public class LoanController {
    @Autowired
    LoanService loanService;
    @RequestMapping(value = "/createLoan")
    public void createLoan (Double Amount, Double InsertRate) {
        loanService.createLoan(Amount, InsertRate);

    }
}
