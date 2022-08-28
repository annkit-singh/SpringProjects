package com.EntityDemo.EntityManagerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.EntityDemo.EntityManagerdemo.repository.CourseRepository;
import com.EntityDemo.EntityManagerdemo.repository.StudentRepository;



@SpringBootApplication
public class EntityManagerDemoApplication implements CommandLineRunner {

	@Autowired
	private CourseRepository courseRepo;
	
	@Autowired 
	private StudentRepository studentRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(EntityManagerDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		System.out.println(repo.findById(100));
		
		studentRepo.saveStudentWithPassport();
		
		//repo.deleteById(100);
		
		
	}
	
	

}
