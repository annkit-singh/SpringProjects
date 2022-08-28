package com.dbrelationship.Hibernate.DB.relationship.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
// @Entity
// @Inheritance(strategy = InheritanceType.JOINED)
public abstract class Employee {
	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	public Employee() {

	}

	public Employee(String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Employee(Integer id, String name) {
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

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}
