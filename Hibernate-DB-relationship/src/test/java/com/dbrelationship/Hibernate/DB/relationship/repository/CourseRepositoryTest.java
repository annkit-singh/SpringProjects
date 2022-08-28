package com.dbrelationship.Hibernate.DB.relationship.repository;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.dbrelationship.Hibernate.DB.relationship.HibernateDbRelationshipApplication;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = HibernateDbRelationshipApplication.class)
public class CourseRepositoryTest {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repository;

	@Autowired
	EntityManager em;

	@Autowired
	StudentRepository studentRepo;

	@Test
	public void findById_basic() {

	}

}
