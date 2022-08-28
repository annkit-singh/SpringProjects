package com.in10minutes.basic.springaopin10steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.in10minutes.basic.springaopin10steps.business.Business1;
import com.in10minutes.basic.springaopin10steps.business.Business2;

@SpringBootApplication
public class SpringAopIn10StepsApplication  implements CommandLineRunner{
	
	Logger logger =LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	Business1 business1;
	
	@Autowired
	Business2 business2;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringAopIn10StepsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		logger.info(business1.calculateSomething());	
		logger.info(business2.calculateSomething());
	}
	
}
