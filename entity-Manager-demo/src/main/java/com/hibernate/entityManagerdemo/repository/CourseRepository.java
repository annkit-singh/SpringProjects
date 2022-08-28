package com.hibernate.entityManagerdemo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hibernate.entityManagerdemo.entity.Course;
import com.hibernate.entityManagerdemo.entity.Review;
import com.hibernate.entityManagerdemo.entity.ReviewRating;

@Repository
@Transactional
public class CourseRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public Course findById(Integer id) {
		return em.find(Course.class, id);
	}

	public Course save(Course course) {

		if (course.getId() == null) {
			em.persist(course);
		} else {
			em.merge(course);
		}

		return course;
	}

	public void deleteById(Integer id) {
		Course course = findById(id);
		em.remove(course);
	}

	public void playWithEntityManager() {
		Course course1 = new Course("Web Services in 100 Steps");
		em.persist(course1);

		Course course2 = findById(10001);

		course2.setName("JPA in 50 Steps - Updated");

	}

	public void addHardCodedReviewsForCourse() {
		// get the course 10003
		Course course = findById(10003);
		logger.info("course.getReviews() -> {}", course.getReviews());

		// add 2 reviews to it Review review1 = new Review(ReviewRating.ZERO, "Great
		// Hands on Stuff");
		Review review1 = new Review(ReviewRating.FOUR, "Good to Have Stuff");
		Review review2 = new Review(ReviewRating.ZERO, "Great Hands on Stuff");

		// setting the relationship
		course.addReview(review1);
		review1.setCourse(course);
		//
		// course.addReview(review2);
		// review2.setCourse(course);

		// save it to the database
		em.persist(review1);
		// em.persist(review2);
	}

	public void addReviewsForCourse(List<Review> reviewList, Integer id) {
		// get the course 10003
		Course course = findById(id);

		for (Review review : reviewList) {
			course.addReview(review);
			review.setCourse(course);
			em.persist(review);
		}

	}
}