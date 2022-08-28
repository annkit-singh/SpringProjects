package com.EntityDemo.EntityManagerdemo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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
public class NativeQueriesTest {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	public void native_queries_basic() {
		Query query=entityManager.createNativeQuery("SELECT * from Course",Course.class);
		List resultList = query.getResultList();
		logger.info("NATIVE QUERY  --- Select * from course",resultList);
	}
	
	
	

}
