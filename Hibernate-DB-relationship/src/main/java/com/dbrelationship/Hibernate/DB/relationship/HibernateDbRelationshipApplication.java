package com.dbrelationship.Hibernate.DB.relationship;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dbrelationship.Hibernate.DB.relationship.entity.Employee;
import com.dbrelationship.Hibernate.DB.relationship.entity.FullTimeEmployee;
import com.dbrelationship.Hibernate.DB.relationship.entity.PartTimeEmployee;
import com.dbrelationship.Hibernate.DB.relationship.repository.CourseRepository;
import com.dbrelationship.Hibernate.DB.relationship.repository.EmployeeRepository;
import com.dbrelationship.Hibernate.DB.relationship.repository.StudentRepository;

@SpringBootApplication
public class HibernateDbRelationshipApplication implements CommandLineRunner {
	@Autowired
	CourseRepository courseRepo;

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	EmployeeRepository employeeRepo;

	public static void main(String[] args) {
		SpringApplication.run(HibernateDbRelationshipApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		// System.out.println("Information of the ID -----------------------");
		// System.out.println(courseRepo.findById(100));

		// List<Review> reviewList = new ArrayList<Review>();
		// reviewList.add(new Review("5", "Bombastic Movie"));
		// reviewList.add(new Review("4", "Pathetic Movie"));
		// reviewList.add(new Review("6", "Disgurting Movie"));
		//
		// courseRepo.addReviewsForCourse(reviewList, 10001);

		// studentRepo.insertStudentAndCourses(new Course("Microservices"), new
		// Student("Aankit"));

		// employeeRepo.insertEmployee(new FullTimeEmployee("Jack", new
		// BigDecimal("50")));
		//
		// employeeRepo.retrieveAllEmployees();
		Employee e = new PartTimeEmployee("Vinay", new BigDecimal("50"));
		Employee e2 = new FullTimeEmployee("Ronit", new BigDecimal("20000"));
		employeeRepo.insert(e);
		employeeRepo.insert(e2);

		employeeRepo.retrieveFullTimeEmployees();
		employeeRepo.retrievePartTimeEmployees();

	}

}
