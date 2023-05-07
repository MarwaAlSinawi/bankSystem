package com.bankSystem.com.bankSystem.codline.Controlles;

import com.bankSystem.com.bankSystem.codline.Models.CreditCard;
import com.bankSystem.com.bankSystem.codline.Models.Customer;
import com.bankSystem.com.bankSystem.codline.Repositories.CreditCardRepository;
import com.bankSystem.com.bankSystem.codline.Repositories.CustomerRepository;
import com.bankSystem.com.bankSystem.codline.RequestObject.CustomerRequest;
import com.bankSystem.com.bankSystem.codline.RequestObject.LoanRequest;
import com.bankSystem.com.bankSystem.codline.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "Customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    // Create a new customer record
    @RequestMapping(value = "/createCustomer")
    public void createCustomer(String name, String email, String phone) {
        customerService.createCustomer(name,email,phone);
    }
    @RequestMapping(value = "/getAllCustomer", method = RequestMethod.GET)
    //function that returns all Customer
    public List<Customer> getAllCustomer() {
        CustomerRepository customerRepository;
        List<Customer> customers= customerService.getAllCustomer();
        return customers;
    }
    @RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
    public String updateCustomer(CustomerRequest customerRequest) {
        try {
            customerService.updateCustomer(customerRequest);
        } catch (Exception e) {
            return "Failed try again";
        }
        return "Customer update Successfully :)";
    }
}


