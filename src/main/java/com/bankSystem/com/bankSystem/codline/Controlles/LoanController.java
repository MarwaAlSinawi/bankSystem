package com.bankSystem.com.bankSystem.codline.Controlles;

import com.bankSystem.com.bankSystem.codline.Models.Customer;
import com.bankSystem.com.bankSystem.codline.Models.Loan;
import com.bankSystem.com.bankSystem.codline.Repositories.CustomerRepository;
import com.bankSystem.com.bankSystem.codline.Repositories.LoanRepository;
import com.bankSystem.com.bankSystem.codline.RequestObject.CreditCardRequest;
import com.bankSystem.com.bankSystem.codline.RequestObject.LoanRequest;
import com.bankSystem.com.bankSystem.codline.RequestObject.TransactionRequest;
import com.bankSystem.com.bankSystem.codline.Services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "Loan")
public class LoanController {
    @Autowired
    LoanService loanService;


    @RequestMapping(value = "/createLoan", method = RequestMethod.POST)
    public String createLoan(LoanRequest loanRequest) {
        try {
            loanService.createLoan(loanRequest);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Loan Created Successfully :)";
    }
    @RequestMapping(value = "/getAllLoan", method = RequestMethod.GET)
    //function that returns all Loan
    public List<Loan> getAllLoan() {
        LoanRepository loanRepository;
        List<Loan> loans=loanService.getAllLoan();
        return loans;
    }
    @RequestMapping(value = "/updateLoan", method = RequestMethod.POST)
    public String updateLoan(LoanRequest loanRequest) {
        try {
            loanService.updateLoan(loanRequest);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Loan update Successfully :)";
    }
    @RequestMapping(value = "/deleteLoanById", method = RequestMethod.POST)
    public String deleteLoanById(LoanRequest loanRequest) {
        try {
            loanService.deleteLoanById(loanRequest);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Loan deleted Successfully :)";
    }
    @RequestMapping(value = "/getCustomerLoansActivationStatus", method = RequestMethod.GET)
    public Boolean getCustomerLoansActivationStatus(@RequestParam Integer customerId) {
        Boolean loan = loanService.getCustomerLoans(customerId);
        return loan;
    }
}
