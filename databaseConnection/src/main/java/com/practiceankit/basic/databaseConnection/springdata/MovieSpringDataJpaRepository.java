package com.practiceankit.basic.databaseConnection.springdata;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practiceankit.basic.databaseConnection.entity.Movie;

public interface MovieSpringDataJpaRepository extends JpaRepository<Movie, Integer>{
	

}
