package com.EntityDemo.EntityManagerdemo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.EntityDemo.EntityManagerdemo.entity.Course;

@Transactional
@Repository
public class CourseRepository {
	
	@Autowired
	EntityManager entitymanager;
	
	public Course findById(Integer id) {
		return entitymanager.find(Course.class, id);
	}
	

	public Course save(Course course) {

		if (course.getId() == null) {
			entitymanager.persist(course);
		} else {
			entitymanager.merge(course);
		}

		return course;
	}

	public void deleteById(Integer id) {
		Course course = findById(id);
		entitymanager.remove(course);
	}

	public void playWithEntityManager() {
		Course course1 = new Course("Web Services in 100 Steps");
		entitymanager.persist(course1);

		course1.setName(null);
	}
	

}
