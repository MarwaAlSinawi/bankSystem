package com.bankSystem.com.bankSystem.codline.Controlles;

import com.bankSystem.com.bankSystem.codline.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
