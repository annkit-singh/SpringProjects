package com.movie.moviemanager.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.movie.moviemanager.entity.Movie;
import com.movie.moviemanager.service.MovieService;

@RestController
public class MovieController {
	
	@Autowired 
	MovieService service;
	
	
	@GetMapping("director-name/movies")
	public List<Movie> getAllMovies(){
		return service.getAllMovies();
	}
	
	
	@GetMapping("director-name/movies/{id}")
	public Movie getMovieById(@PathVariable Long id){
		return service.getMovieById(id);
	}
	
	@PostMapping("director-name/movies")
	public ResponseEntity<Void> addMovie(@RequestBody Movie movie){
		service.addMovie(movie);
		URI uri=ServletUriComponentsBuilder.fromCurrentRequest().path("/id").buildAndExpand(movie.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping("director-name/movies/{id}")
	public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
		Movie movie = service.getMovieById(id);
		if(movie.equals(null)) {
			return ResponseEntity.notFound().build();
		}
		service.deleteMovie(id);
		return ResponseEntity.noContent().build();
		
	}
	
	@PutMapping("director-name/movies/{id}")
	public ResponseEntity<Movie> updateMovie(@PathVariable Long id,@RequestBody Movie movie){
		service.addMovie(movie);
		return new ResponseEntity<Movie>(movie,HttpStatus.OK);
	}
	
	
	
	
	

}
