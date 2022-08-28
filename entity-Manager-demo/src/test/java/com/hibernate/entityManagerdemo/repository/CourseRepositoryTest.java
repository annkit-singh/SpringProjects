package com.hibernate.entityManagerdemo.repository;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.entityManagerdemo.EntityManagerDemoApplication;
import com.hibernate.entityManagerdemo.entity.Course;
import com.hibernate.entityManagerdemo.entity.Review;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EntityManagerDemoApplication.class)
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository courseRepo;

	@Autowired
	EntityManager entityManager;

	@Test
	public void courseIdTest() {
		Course course = courseRepo.findById(10001);
		assertEquals("JPA in 50 Steps", course.getName());
	}

	@Transactional
	@Test
	public void courseIdTestFirstLevelCache() {
		Course course = courseRepo.findById(10001);
		logger.info("Fetching information of course 10001  --> {}", course);

		Course course1 = courseRepo.findById(10001);
		logger.info("Fetching information of course 10001  again --> {}", course1);
	}

	@Test
	public void findById_basic() {
		Course course = courseRepo.findById(10001);
		assertEquals("JPA in 50 Steps", course.getName());
	}

	@Transactional
	@Test
	@DirtiesContext
	public void deleteById_basic() {

		courseRepo.deleteById(10002);

		assertNull(courseRepo.findById(10002));
	}

	@Test
	@DirtiesContext
	public void save_basic() {
		// get a course
		Course course = courseRepo.findById(10001);
		assertEquals("JPA in 50 Steps", course.getName());

		// update details
		course.setName("JPA in 50 Steps - Updated");
		courseRepo.save(course);

		// check the value
		Course course1 = courseRepo.findById(10001);
		assertEquals("JPA in 50 Steps - Updated", course1.getName());
	}

	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		courseRepo.playWithEntityManager();
	}

	@Test
	@Transactional
	public void retrieveReviewsForCourse() {
		Course course = courseRepo.findById(10001);
		logger.info("{}", course.getReviews());
	}

	@Test
	@Transactional
	public void retrieveCourseForReview() {
		Review review = entityManager.find(Review.class, 50001L);
		logger.info("{}", review.getCourse());
	}

}
