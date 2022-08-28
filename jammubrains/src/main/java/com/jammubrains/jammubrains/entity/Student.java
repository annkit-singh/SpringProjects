package com.jammubrains.jammubrains.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {
	
	@GeneratedValue
	@Id
	private Long Id;
	private String name;
	private String city;
	
	public Student() {}
	
	
	public Student(Long id, String name, String city) {
		super();
		Id = id;
		this.name = name;
		this.city = city;
	}


	@Override
	public String toString() {
		return String.format("Student [Id=%s, name=%s, city=%s]", Id, name, city);
	}
	
	
	

	
}
