package com.hibernate.entityManagerdemo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PreRemove;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@NamedQueries(value = { @NamedQuery(name = "query_get_all_courses", query = "Select  c  From Course c"),
		@NamedQuery(name = "query_get_100_Step_courses", query = "Select  c  From Course c where name like '%100 Steps'"),
		@NamedQuery(name = "query_get_all_courses_join_fetch", query = "Select c From Course c JOIN FETCH c.students s") })
@Cacheable
@SQLDelete(sql = "update course set is_deleted=true where id=?")
@Where(clause = "is_deleted = false")
public class Course {

	public static Logger logger = LoggerFactory.getLogger(Course.class);
	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	@OneToMany(mappedBy = "course")
	private List<Review> reviews = new ArrayList<>();

	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	private LocalDateTime createdDate;

	private boolean isDeleted;

	@JsonIgnore
	@ManyToMany(mappedBy = "courses")
	private List<Student> students = new ArrayList<>();

	@PreRemove
	private void preRemove() {
		logger.info("Pre Remove method called ");

		this.isDeleted = true;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void addStudents(Student students) {
		this.students.add(students);
	}

	public Course() {

	}

	public Course(String name) {
		super();
		this.id = id;
		this.name = name;

	}

	public Course(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void addReview(Review review) {
		this.reviews.add(review);
	}

	public void removeReview(Review review) {
		this.reviews.remove(review);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}

}
