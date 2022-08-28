package com.movie.moviemanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.moviemanager.entity.Movie;
import com.movie.moviemanager.repository.MovieRepository;

@Service
public class MovieService {
	
	@Autowired
	MovieRepository repository;
	
	public List<Movie> getAllMovies(){
		return repository.findAll();
	}
	
	public Movie getMovieById(Long id){
		return repository.findById(id);
	}
	
	public Movie addMovie(Movie movie) {
		return repository.addMovie(movie);
	}
	
	public void deleteMovie(Long id) {
		 repository.deleteMovie(id);
	}
	
	

}
