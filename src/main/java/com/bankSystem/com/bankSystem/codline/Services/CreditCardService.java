package com.bankSystem.com.bankSystem.codline.Services;

import com.bankSystem.com.bankSystem.codline.Models.Account;
import com.bankSystem.com.bankSystem.codline.Models.CreditCard;
import com.bankSystem.com.bankSystem.codline.Models.Customer;
import com.bankSystem.com.bankSystem.codline.Repositories.CreditCardRepository;
import com.bankSystem.com.bankSystem.codline.Repositories.CustomerRepository;
import com.bankSystem.com.bankSystem.codline.RequestObject.CreditCardRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

@Service
public class CreditCardService {


        @Autowired
        private CreditCardRepository creditCardRepository;

        @Autowired
        private CustomerRepository customerRepository;

        public void createCreditCard(CreditCardRequest creditCardRequest) {
            CreditCard creditCard = new CreditCard();
            creditCard.setCardNumber(creditCardRequest.getCardNumber());
            creditCard.setCreditLimit(creditCardRequest.getCreditLimit());
            creditCard.setUpdatedDate(new Date());
            creditCard.setCreatedDate(new Date());
            creditCard.setIsActive(Boolean.TRUE);
            Customer customer = customerRepository.findById(creditCardRequest.getCustomerID()).get();
            creditCard.setCustomer(customer);
            creditCardRepository.save(creditCard);
        }
    public List<CreditCard> getAllCreditCard() {
        return creditCardRepository.getAllCreditCard();

    }
    }

