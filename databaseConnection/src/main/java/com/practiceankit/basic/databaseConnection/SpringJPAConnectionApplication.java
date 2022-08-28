package com.practiceankit.basic.databaseConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import com.practiceankit.basic.databaseConnection.entity.Movie;
import com.practiceankit.basic.databaseConnection.jpa.PersonJpaRepository;


//@SpringBootApplication
public class SpringJPAConnectionApplication implements CommandLineRunner {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;
	public static void main(String[] args)  {
		SpringApplication.run(SpringJPAConnectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	// TODO Auto-generated method stub
	logger.info("\n List of Movies {} "	,repository.findById(102));
	
		logger.info("\n List of Movies id 101 {} "	,repository.findAll());
		logger.info("\n Inserting Values {}"	,repository.insertValues(new Movie(120,"Pakistan MKB",1900000,"Sprituality")));
		logger.info("\n Deleting Values----   "	);
		repository.deleteValues(101);
		
	}

}
