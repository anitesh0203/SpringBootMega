package com.example.parallel.parallelApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example")
public class ParallelAppApplication {

	public static void main(String[] args) {
		System.out.println("starting");

		SpringApplication.run(ParallelAppApplication.class, args);
	}

}
