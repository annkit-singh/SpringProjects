package com.dbrelationship.Hibernate.DB.relationship.repository;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dbrelationship.Hibernate.DB.relationship.entity.Course;
import com.dbrelationship.Hibernate.DB.relationship.entity.Passport;
import com.dbrelationship.Hibernate.DB.relationship.entity.Student;

@Repository
@Transactional
public class StudentRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public Student findById(Long id) {
		return em.find(Student.class, id);
	}

	public Student save(Student student) {

		if (student.getId() == null) {
			em.persist(student);
		} else {
			em.merge(student);
		}

		return student;
	}

	public void deleteById(Long id) {
		Student student = findById(id);
		em.remove(student);
	}

	public void saveStudentWithPassport() {
		Passport passport = new Passport("Z123456");
		em.persist(passport);

		Student student = new Student("Mike");

		student.setPassport(passport);
		em.persist(student);
	}

	public void someOperationToUnderstandPersistenceContext() {
		// Database Operation 1 - Retrieve student
		Student student = em.find(Student.class, 20001L);
		// Persistence Context (student)

		// Database Operation 2 - Retrieve passport
		Passport passport = student.getPassport();
		// Persistence Context (student, passport)

		// Database Operation 3 - update passport
		passport.setNumber("E123457");
		// Persistence Context (student, passport++)

		// Database Operation 4 - update student
		student.setName("Ranga - updated");
		// Persistence Context (student++ , passport++)
	}

	@Test
	@Transactional
	public void addHardCodedStudentAndCourses() {
		Student student = new Student("Jack");
		Course course = new Course("Microservices in 40 Steps");

		Passport passport = new Passport("A-19938");

		em.persist(student);
		em.persist(course);
		em.persist(passport);

		student.setPassport(passport);
		student.addCourse(course);
		course.addStudents(student);

		// to persist the owning side to establish the relationship
		em.persist(student);
	}

	@Test
	@Transactional
	public void insertStudentAndCourses(Course course, Student student) {
		em.persist(student);
		em.persist(course);

		student.addCourse(course);
		course.addStudents(student);
		// to persist the owning side to establish the relationship
		em.persist(student);
	}
}