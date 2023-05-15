package com.bankSystem.com.bankSystem.codline.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Setter
@Getter
@Data
public class TransactionRequest {
    Integer id;

    Double Amount ;

    String TransactionDate;

    Integer CreditCard_Id;

    private Integer accountNumber;
    private String isActive;
}
