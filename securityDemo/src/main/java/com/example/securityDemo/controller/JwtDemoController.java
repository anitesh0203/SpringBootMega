package com.example.securityDemo.controller;


import com.example.securityDemo.model.MyUser;
import com.example.securityDemo.service.JwtService;
import com.example.securityDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
public class JwtDemoController {

    @Autowired
    JwtService jwtService;

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public MyUser register(@RequestBody MyUser user) {
        return userService.addUserToDb(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody MyUser user) throws NoSuchAlgorithmException {
        return jwtService.getToken(user);
    }
    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome Babuu!!";
    }
}
