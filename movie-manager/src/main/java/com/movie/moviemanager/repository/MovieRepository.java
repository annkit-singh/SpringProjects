package com.movie.moviemanager.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.movie.moviemanager.entity.Movie;

@Repository
public class MovieRepository {
	

	@Autowired
	MovieJpaRepository jpaRepo;
	
	public List<Movie> findAll(){
		return jpaRepo.findAll();	
	}
	
	public Movie findById(Long id) {
		Optional<Movie> movie = jpaRepo.findById(id);
		return movie.get();
	}
	
	public Movie addMovie(Movie movie) {
		return jpaRepo.save(movie);
	}
	
	public void deleteMovie(Long id) {
		Movie movie = findById(id);
		jpaRepo.delete(movie);
	}
	
	
	
	

}
