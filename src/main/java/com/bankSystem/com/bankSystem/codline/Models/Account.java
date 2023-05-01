package com.bankSystem.com.bankSystem.codline.Models;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Data
public class Account extends  BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     Integer id;


     Double balance;



     Integer AccountNumber;

     @ManyToOne
     @JoinColumn(name="Customer_Id",referencedColumnName = "id")
     Customer customer;


}
