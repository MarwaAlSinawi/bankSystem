package com.bankSystem.com.bankSystem.codline.Models;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name="account_transaction")
public class Transaction extends  BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Integer id;


    Double Amount ;



    Date TransactionDate;



}
