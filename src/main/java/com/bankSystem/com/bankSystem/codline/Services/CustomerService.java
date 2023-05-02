package com.bankSystem.com.bankSystem.codline.Services;

import com.bankSystem.com.bankSystem.codline.Models.CreditCard;
import com.bankSystem.com.bankSystem.codline.Models.Customer;
import com.bankSystem.com.bankSystem.codline.Repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

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
    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();


    }
}
