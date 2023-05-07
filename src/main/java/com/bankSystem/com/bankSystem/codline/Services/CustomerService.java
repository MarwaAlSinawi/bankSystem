package com.bankSystem.com.bankSystem.codline.Services;

import com.bankSystem.com.bankSystem.codline.Models.CreditCard;
import com.bankSystem.com.bankSystem.codline.Models.Customer;
import com.bankSystem.com.bankSystem.codline.Models.Loan;
import com.bankSystem.com.bankSystem.codline.Repositories.CustomerRepository;
import com.bankSystem.com.bankSystem.codline.RequestObject.CustomerRequest;
import com.bankSystem.com.bankSystem.codline.RequestObject.LoanRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
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
    public void updateCustomer(CustomerRequest customerRequest)throws ParseException {
        Customer customer=customerRepository.getCustomerById(customerRequest.getId());
        customer.setName(customerRequest.getName());
        customer.setEmail(customerRequest.getEmail());
        customer.setPhone(customerRequest.getPhone());
        customer.setIsActive(Boolean.TRUE);
        customerRepository.save(customer);
    } public void deleteCustomerById(CustomerRequest customerRequest) {
        Customer customer=customerRepository.getCustomerById(customerRequest.getId());
        customer.setIsActive(Boolean.FALSE);
        customerRepository.save(customer);

    }
}
