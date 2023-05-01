package com.bankSystem.com.bankSystem.codline.Services;

import com.bankSystem.com.bankSystem.codline.Models.Customer;
import com.bankSystem.com.bankSystem.codline.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;
    public  void createCustomer(String name, String email, String phone) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setCreatedDate(new Date()); //
        customer.setUpdatedDate(new Date()); //
        customer.setIsActive(Boolean.TRUE);
        customerRepository.save(customer);
    }
}
