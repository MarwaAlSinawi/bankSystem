package com.bankSystem.com.bankSystem.codline.RequestObject;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@Data
public class AccountRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    Double balance;
    Integer AccountNumber;

    Integer customerId;
}
