package com.bankSystem.com.bankSystem.codline.Repositories;

import com.bankSystem.com.bankSystem.codline.Models.Account;
import com.bankSystem.com.bankSystem.codline.Models.CreditCard;
import com.bankSystem.com.bankSystem.codline.Models.Customer;
import com.bankSystem.com.bankSystem.codline.Models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {


    @Query("SELECT c from Customer c where c.id=:customerId")
    Customer getCustomerById(@Param("customerId" ) Integer id);

    @Query("SELECT c from Customer c")
    List<Customer> getAllCustomer();


    @Query(value = "Select a From Account a WHERE a.customer.id = :id")
    List<Account> getCustomerAccountInformation(@Param("id") Integer customerId);


}
