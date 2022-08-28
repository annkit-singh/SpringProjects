package com.hibernate.entityManagerdemo.repository;

import java.util.List;

import javax.persistence.EntityGraph;
import javax.persistence.EntityManager;
import javax.persistence.Subgraph;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hibernate.entityManagerdemo.EntityManagerDemoApplication;
import com.hibernate.entityManagerdemo.entity.Course;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = EntityManagerDemoApplication.class)
public class PerformanceTuningTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;
	@Autowired
	EntityManager em;

	@Test
	@Transactional
	public void creatingNPlusOneProblem() {
		List<Course> courses = em.createNamedQuery("query_get_all_courses", Course.class).getResultList();
		for (Course course : courses) {
			logger.info("Course -> {} Students -> {}", course, course.getStudents());
		}
	}

	@Test
	@Transactional
	public void solvingNPlusOneProblem() {
		EntityGraph<Course> entityGraph = em.createEntityGraph(Course.class);
		Subgraph<Object> subGraph = entityGraph.addSubgraph("students");

		List<Course> courses = em.createNamedQuery("query_get_all_courses", Course.class)
				.setHint("javax.persistence.loadgraph", entityGraph).getResultList();
		for (Course course : courses) {
			logger.info("Course -> {} Students -> {}", course, course.getStudents());
		}
	}

	@Test
	@Transactional
	public void creatingNPlusOneProblem_joinFetch() {
		List<Course> courses = em.createNamedQuery("query_get_all_courses_join_fetch", Course.class).getResultList();
		for (Course course : courses) {
			logger.info("Course -> {} Students -> {}", course, course.getStudents());
		}

	}

}