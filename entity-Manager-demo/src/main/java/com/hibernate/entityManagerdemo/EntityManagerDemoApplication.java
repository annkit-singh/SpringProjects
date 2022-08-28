package com.hibernate.entityManagerdemo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.hibernate.entityManagerdemo.entity.FullTimeEmployee;
import com.hibernate.entityManagerdemo.entity.PartTimeEmployee;
import com.hibernate.entityManagerdemo.repository.CourseRepository;
import com.hibernate.entityManagerdemo.repository.EmployeeRepository;

@SpringBootApplication
@ComponentScan(basePackages = { "com.hibernate.entityManagerdemo.repository" })
public class EntityManagerDemoApplication implements CommandLineRunner {

	@Autowired
	private CourseRepository repository;

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(EntityManagerDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		employeeRepository.insert(new FullTimeEmployee("Akshay", new BigDecimal("50000")));
		employeeRepository.insert(new PartTimeEmployee("Vinay", new BigDecimal("20")));
		repository.deleteById(10001);
	}

}
