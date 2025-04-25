package com.example.securityDemo.repository;

import com.example.securityDemo.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<MyUser,Integer> {
    MyUser getUserByName(String name);
}
