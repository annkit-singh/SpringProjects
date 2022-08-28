package com.EntityDemo.EntityManagerdemo.repository;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.EntityDemo.EntityManagerdemo.entity.Passport;
import com.EntityDemo.EntityManagerdemo.entity.Student;

@Transactional
@Repository
public class StudentRepository {
	
	@Autowired
	EntityManager entitymanager;
	
	public Student findById(Integer id) {
		return entitymanager.find(Student.class, id);
	}
	

	public Student save(Student Student) {

		if (Student.getId() == null) {
			entitymanager.persist(Student);
		} else {
			entitymanager.merge(Student);
		}

		return Student;
	}

	public void deleteById(Integer id) {
		Student Student = findById(id);
		entitymanager.remove(Student);
	}

	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z123456");
		Student student = new Student("Mike");
		student.setPassport(passport);
		entitymanager.persist(passport);

	}
	

}
