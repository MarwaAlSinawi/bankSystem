package com.bankSystem.com.bankSystem.codline.Repositories;

import com.bankSystem.com.bankSystem.codline.Models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Integer> {
}
