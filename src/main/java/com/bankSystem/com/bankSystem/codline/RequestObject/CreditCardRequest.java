package com.bankSystem.com.bankSystem.codline.RequestObject;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CreditCardRequest {
    Integer cardNumber;

    Double CreditLimit;

    Integer customerID;

}
