package com.rest.services.restservices.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotDefinedException extends RuntimeException {

	public UserNotDefinedException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
	

}
