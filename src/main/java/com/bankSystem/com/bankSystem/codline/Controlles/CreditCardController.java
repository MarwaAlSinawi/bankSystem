package com.bankSystem.com.bankSystem.codline.Controlles;

import com.bankSystem.com.bankSystem.codline.Models.Account;
import com.bankSystem.com.bankSystem.codline.Models.CreditCard;
import com.bankSystem.com.bankSystem.codline.Repositories.AccountRepository;
import com.bankSystem.com.bankSystem.codline.Repositories.CreditCardRepository;
import com.bankSystem.com.bankSystem.codline.RequestObject.CreditCardRequest;
import com.bankSystem.com.bankSystem.codline.Services.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "CreditCard")
public class CreditCardController {
    @Autowired
    CreditCardService creditCardService;

    @RequestMapping(value = "/createCreditCard", method = RequestMethod.POST)
    public String createCreditCard(CreditCardRequest creditCardRequest) {
        try {
            creditCardService.createCreditCard(creditCardRequest);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Credit Card Created Successfully :)";
    }
    @RequestMapping(value = "/getAllCreditCard", method = RequestMethod.GET)
    //function that returns all CreditCard
    public List<CreditCard> getAllCreditCard() {
        CreditCardRepository creditCardRepository;
        List<CreditCard> creditCards = creditCardService.getAllCreditCard();

        return creditCards;
    }
}
