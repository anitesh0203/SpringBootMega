package com.example.securityDemo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class MyUser {

    @Id
    int id;
    String name;
    String password;
}
