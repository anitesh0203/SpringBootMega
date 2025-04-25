package com.example.hibernateDemo.service;

import com.example.hibernateDemo.model.Student;
import com.example.hibernateDemo.repository.StudentJPARepo;
import com.example.hibernateDemo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class StudentService {

    @Autowired
    StudentJPARepo studentRepository;
    public Student addRecord(Student student) {
        return (Student) studentRepository.save(student);
    }

    public List<Student> getData() {

        return studentRepository.findAll();
    }
}
