package com.spring.basic.springin10steps;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BooksController {
	
	@GetMapping("/books")
	public List<Books> getBooks(){
		return Arrays.asList(
				new Books(102, "Learn to strive", "Jonathan"),
				new Books(103, "Learn to drive", "Kunal")
				);
	}

}
