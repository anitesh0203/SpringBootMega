package com.example.securityDemo.service;


import com.example.securityDemo.model.MyUser;
import com.example.securityDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public MyUser getUserFromDb(String name) {
        return repository.getUserByName(name);
    }

    public MyUser addUserToDb(MyUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }
}
