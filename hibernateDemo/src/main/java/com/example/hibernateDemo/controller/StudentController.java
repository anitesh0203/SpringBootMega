package com.example.hibernateDemo.controller;


import com.example.hibernateDemo.model.Student;
import com.example.hibernateDemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService service;
    @GetMapping("/student")
    public List<Student> getStudent() {
        return service.getData();
    }


    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student) {
        return service.addRecord(student);
    }
}
