package com.bankSystem.com.bankSystem.codline.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Getter
@Setter
@Data
public class LoanRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    Double Amount ;



    Double InsertRate;

    Integer Customer_Id;
}
