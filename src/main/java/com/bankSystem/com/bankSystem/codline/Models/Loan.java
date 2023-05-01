package com.bankSystem.com.bankSystem.codline.Models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Data
public class Loan extends  BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    Double Amount ;



    Double InsertRate;



}
