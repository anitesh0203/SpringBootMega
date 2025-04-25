package com.example.hibernateDemo;

import com.example.hibernateDemo.model.Student;
import com.example.hibernateDemo.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateDemoApplication {


	public static void main(String[] args) {

		SpringApplication.run(HibernateDemoApplication.class, args);

//		Student student = new Student();
//		student.setId(1232);
//		student.setCity("Pune");
//		student.setName("Ravish");
//		StudentService service = new StudentService();
//		service.addRecord(student);
//		System.out.println(service.getData());
	}

}
