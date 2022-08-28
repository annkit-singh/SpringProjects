package com.EntityDemo.EntityManagerdemo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.EntityDemo.EntityManagerdemo.EntityManagerDemoApplication;
import com.EntityDemo.EntityManagerdemo.entity.Course;
import com.EntityDemo.EntityManagerdemo.entity.Passport;
import com.EntityDemo.EntityManagerdemo.entity.Student;

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EntityManagerDemoApplication.class)
public class StudentRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;

	@Autowired
	EntityManager entityManager;
	
	@Test
	public void retrieveStudentWithPassport()
	{
		Student student=entityManager.find(Student.class,20001L);
		logger.info(" Student -> {}",student);
		logger.info(" Passport --> {} ",student.getPassport());
	}
	
	@Test
	public void retrievePassportAndAssociatedStudent()
	{
		Passport passport=entityManager.find(Passport.class,40001L);
		logger.info(" Student -> {}",passport);
		logger.info(" Passport --> {} ",passport.getStudent());
	}
	
}
