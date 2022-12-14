package com.EntityDemo.EntityManagerdemo.repository;


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
import org.springframework.test.context.junit4.SpringRunner;

import com.EntityDemo.EntityManagerdemo.EntityManagerDemoApplication;
import com.EntityDemo.EntityManagerdemo.entity.Course;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = EntityManagerDemoApplication.class)
public class JPQLTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	@Test
	public void jpql_basic() {
		Query query = em.createNamedQuery("query_get_all_courses");  //named query
		List resultList = query.getResultList();
		logger.info("Select  c  From Course c -> {}",resultList);
	}

	@Test
	public void jpql_typed() {
		TypedQuery<Course> query = 
					em.createQuery("Select  c  From Course c", Course.class);
		
		List<Course> resultList = query.getResultList();
		
		logger.info("Select  c  From Course c -> {}",resultList);
	}

	@Test
	public void jpql_where() {
		TypedQuery<Course> query = 
					em.createNamedQuery("Select  c  From Course c where name like '%100 Steps'", Course.class);
		
		List<Course> resultList = query.getResultList();
		
		logger.info("Select  c  From Course c where name like '%100 Steps'-> {}",resultList);
		//[Course[Web Services in 100 Steps], Course[Spring Boot in 100 Steps]]
	}

}