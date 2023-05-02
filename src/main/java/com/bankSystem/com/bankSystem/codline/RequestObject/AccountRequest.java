package com.bankSystem.com.bankSystem.codline.RequestObject;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class AccountRequest {

    Double balance;
    Integer AccountNumber;

    Integer customerId;
}
