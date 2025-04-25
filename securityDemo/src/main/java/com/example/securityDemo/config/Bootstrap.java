package com.example.securityDemo.config;


import com.example.securityDemo.model.MyUser;
import com.example.securityDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Bootstrap {
    @Autowired
    UserService service;
    @Bean
    public MyUser betterCallSeal() {
        System.out.println("BETTER CALL SEAL");
        MyUser user = new MyUser();
        user.setId(1);
        user.setName("user");
        user.setPassword("password");
        return service.addUserToDb(user);
    }
}
