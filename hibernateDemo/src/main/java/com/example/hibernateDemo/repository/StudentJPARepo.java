package com.example.hibernateDemo.repository;

import com.example.hibernateDemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentJPARepo extends JpaRepository <Student, Integer>{
}
