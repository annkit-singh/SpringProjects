package com.movie.moviemanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movie.moviemanager.entity.Movie;

public interface MovieJpaRepository extends JpaRepository<Movie, Long> {
	
	
	

}
