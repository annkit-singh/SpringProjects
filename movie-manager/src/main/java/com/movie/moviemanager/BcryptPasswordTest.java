package com.movie.moviemanager;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptPasswordTest {
	
	public static void main(String[] args) {
		
	
	BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
	for(int i=0;i<=10;i++) {
//	String encodedString = encoder.encode("password@!23@#!");
		
		String encodedString = encoder.encode("Ankit@2000");
		System.out.println(encodedString);
		}

	}
}
