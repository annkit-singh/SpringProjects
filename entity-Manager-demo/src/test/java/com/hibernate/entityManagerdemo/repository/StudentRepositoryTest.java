package com.hibernate.entityManagerdemo.repository;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.entityManagerdemo.EntityManagerDemoApplication;
import com.hibernate.entityManagerdemo.entity.Address;
import com.hibernate.entityManagerdemo.entity.Passport;
import com.hibernate.entityManagerdemo.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EntityManagerDemoApplication.class)
public class StudentRepositoryTest {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	StudentRepository studentRepository;

	@Autowired
	EntityManager entityManager;

	@Test
	public void testRepo() {
		System.out.println("Testing");
	}

	@Test
	public void someTest() {
		studentRepository.someOperationToUnderstandPersistenceContext();
	}

	@Test
	@Transactional
	public void retrieveStudentAndPassportDetails() {
		Student student = entityManager.find(Student.class, 20001L);
		logger.info("student -> {}", student);
		logger.info("passport -> {}", student.getPassport());
	}

	@Test
	@Transactional
	public void setAddressDetails() {
		Student student = entityManager.find(Student.class, 20001L);
		student.setAddress(new Address("Lane no.6", "near Gayatri Mandir", "Hyderabad"));

	}

	@Test
	@Transactional
	public void retrievePassportAndAssociatedStudent() {
		Passport passport = entityManager.find(Passport.class, 40001L);
		logger.info("passport -> {}", passport);
		logger.info("student -> {}", passport.getStudent());
	}

	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student = entityManager.find(Student.class, 20001L);

		logger.info("student -> {}", student);
		logger.info("courses -> {}", student.getCourses());
	}

}
