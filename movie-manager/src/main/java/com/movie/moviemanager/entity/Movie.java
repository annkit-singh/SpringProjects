package com.movie.moviemanager.entity;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movie {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String directorName;
	private Long collection;
	private Long budget;
	
	
	public Movie() {
		super();
		
	}
	public Movie(Long id, String name, String directorName, Long collection, Long budget) {
		super();
		this.id = id;
		this.name = name;
		this.directorName = directorName;
		this.collection = collection;
		this.budget = budget;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirectorName() {
		return directorName;
	}
	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}
	public Long getCollection() {
		return collection;
	}
	public void setCollection(Long collection) {
		this.collection = collection;
	}
	public Long getBudget() {
		return budget;
	}
	public void setBudget(Long budget) {
		this.budget = budget;
	}
	
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(id, other.id);
	}
	@Override
	public String toString() {
		return String.format("Movie [id=%s, name=%s, directorName=%s, collection=%s, budget=%s]", id, name,
				directorName, collection, budget);
	}
	
	
	
	
		

}
