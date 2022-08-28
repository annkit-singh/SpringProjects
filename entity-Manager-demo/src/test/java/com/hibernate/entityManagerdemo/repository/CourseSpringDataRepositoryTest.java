package com.hibernate.entityManagerdemo.repository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.hibernate.entityManagerdemo.EntityManagerDemoApplication;
import com.hibernate.entityManagerdemo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EntityManagerDemoApplication.class)
public class CourseSpringDataRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseSpringDataRepository courseRepo;

	@Autowired
	EntityManager entityManager;

	@Test
	public void findByIdTestOne() {
		Optional<Course> course = courseRepo.findById(10001);
		assertTrue(course.isPresent());

	}

	@Test
	public void findByIdTestTwo() {
		Optional<Course> course = courseRepo.findById(20001);
		assertFalse(course.isPresent());

	}

	@Test
	public void playWithJpaRepository() {
		Course c = new Course("Microservices in few steps");
		courseRepo.save(c);

		c.setName("Microservices Updated");
		courseRepo.save(c);

	}

	@Test
	public void playWithCrudRepository() {
		List<Course> courseList = courseRepo.findAll();
		logger.info("List of CourseList -->  {}", courseList);

		long count = courseRepo.count();
		logger.info("Count of CourseList -->  {}", count);
	}

	@Transactional
	@Test
	public void testSortFindAll() {
		Sort sort = Sort.by(Sort.Direction.DESC, "name");

		List<Course> courseList = courseRepo.findAll(sort);
		logger.info(" Course List in Desc Order {} ", courseList);
	}

	@Transactional
	@Test
	public void testPagination() {
		PageRequest portion = PageRequest.of(0, 3);
		Page<Course> firstPage = courseRepo.findAll(portion);
		logger.info(" First Page   -> {}" + firstPage.getContent());

		Pageable nextPortion = firstPage.nextPageable();
		Page<Course> nextPage = courseRepo.findAll(nextPortion);
		logger.info(" Second Page -> {} " + nextPage.getContent());

	}

	@Test
	@Transactional
	public void findByNameTest() {
		List<Course> courseList = courseRepo.findByName("JPA in 50 Steps");
		logger.info("Course List  $$$$$$${}", courseList);
	}

}
