package com.bankSystem.com.bankSystem.codline.Models;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;
@Entity
@Data
public class CreditCard extends  BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    Integer CardNumber;



    Double CreditLimit;
    @OneToOne
    @JoinColumn(name="Customer_Id",referencedColumnName = "id")
    Customer customer;

}
