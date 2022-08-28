package com.practiceankit.basic.databaseConnection.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.practiceankit.basic.databaseConnection.entity.Movie;

@Repository
@Transactional
public class PersonJpaRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Movie> findAll(){
		TypedQuery<Movie> rs = entityManager.createNamedQuery("final_all_movies", Movie.class);
		return rs.getResultList();
	}
	
	public Movie findById(Integer id){
		return entityManager.find(Movie.class,id);
	}
	
	public Movie insertValues(Movie movie){
		return entityManager.merge(movie);
	}
	
	public Movie updateValues(Movie movie){
		return entityManager.merge(movie);
	}
	
	public void deleteValues(int id){
		Movie movie=findById(id);
		 entityManager.remove(movie);
	}
	
	

}
