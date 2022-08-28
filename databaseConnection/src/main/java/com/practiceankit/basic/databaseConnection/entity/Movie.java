package com.practiceankit.basic.databaseConnection.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="final_all_movies",query="select m from Movie m")
public class Movie {
	
	@Id
	@GeneratedValue
	Integer Id; 
	String name;
	Integer budget;
	String genre;
		
	public Movie() {
		
	}
	
	public Movie( String name, Integer budget, String genre) {
		super();
		
		this.name = name;
		this.budget = budget;
		this.genre = genre;
	}
	public Movie(Integer id, String name, Integer budget, String genre) {
		super();
		Id = id;
		this.name = name;
		this.budget = budget;
		this.genre = genre;
	}
	
	public Integer getId() {
		return Id;
	}
	public void setId(Integer id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getBudget() {
		return budget;
	}
	public void setBudget(Integer budget) {
		this.budget = budget;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie [Id=" + Id + ", name=" + name + ", budget=" + budget + ", genre=" + genre + "]";
	}
	
	
	

}
