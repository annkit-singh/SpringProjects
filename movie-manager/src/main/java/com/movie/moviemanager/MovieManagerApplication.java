package com.movie.moviemanager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.movie.moviemanager.entity.Movie;
import com.movie.moviemanager.service.MovieService;

@SpringBootApplication
public class MovieManagerApplication implements CommandLineRunner {

	@Autowired
	MovieService service;
	
	public static void main(String[] args) {
		SpringApplication.run(MovieManagerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
//		List<Movie> movies = service.getAllMovies();
//		System.out.println(movies);
	}

}
