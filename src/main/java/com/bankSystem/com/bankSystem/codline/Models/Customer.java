package com.bankSystem.com.bankSystem.codline.Models;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Data
public class Customer extends  BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    String Name;



    String Email;


    String phone;


}
