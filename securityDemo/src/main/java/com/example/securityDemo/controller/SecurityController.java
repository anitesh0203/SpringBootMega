package com.example.securityDemo.controller;


import com.example.securityDemo.model.MyUser;
import com.example.securityDemo.model.Student;
import com.example.securityDemo.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

    @Autowired
    UserService userService;

    @GetMapping("/home")
    public String getData(HttpServletRequest request) {
        return "Home of Dangerous security pvt. ltd" + request.getSession().getId();
    }

    @PostMapping("/home")
    public String addData(@RequestBody Student student) {
        return "Added";
    }

    @GetMapping("/token")
    public CsrfToken getToken(HttpServletRequest request) {
        return (CsrfToken) request.getAttribute("_csrf");
    }

    @PostMapping("/addUser")
    public MyUser addUser(@RequestBody MyUser user) {
        return userService.addUserToDb(user);
    }
}
