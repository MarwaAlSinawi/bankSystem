package com.bankSystem.com.bankSystem.codline.Repositories;

import com.bankSystem.com.bankSystem.codline.Models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
