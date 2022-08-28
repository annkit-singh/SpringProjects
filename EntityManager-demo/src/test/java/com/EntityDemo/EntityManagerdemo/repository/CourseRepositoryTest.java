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

@Transactional
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EntityManagerDemoApplication.class)
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;

	@Autowired
	EntityManager entityManager;
	
	@Test
	public void findById_basic() {
		Course course = repository.findById(100);
		assertEquals("JPA in 50 Steps", course.getName());
	}
	
	@DirtiesContext
	@Test
	public void delete_basic() {
		repository.deleteById(100);
		assertNull(repository.findById(100));
	}
	
	@Test
	@DirtiesContext
	public void save_basic() {

		// get a course
		Course course = repository.findById(100);
		assertEquals("JPA in 50 Steps", course.getName());

		// update details
		course.setName("JPA in 50 Steps - Updated");
		repository.save(course);

		// check the value
		Course course1 = repository.findById(100);
		assertEquals("JPA in 50 Steps - Updated", course1.getName());
	}

	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		repository.playWithEntityManager();
	}
	
	
	
	@Test
	public void jpql_typed() {
		TypedQuery<Course> query = 
					entityManager.createQuery("Select  c  From Course c", Course.class);
		
		List<Course> resultList = query.getResultList();
		
		logger.info("Select  c  From Course c -> {}",resultList);
	}

}
