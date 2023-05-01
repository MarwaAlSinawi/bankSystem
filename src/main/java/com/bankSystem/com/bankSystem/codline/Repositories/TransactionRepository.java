package com.bankSystem.com.bankSystem.codline.Repositories;

import com.bankSystem.com.bankSystem.codline.Models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {


}
