package com.practiceankit.basic.databaseConnection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.practiceankit.basic.databaseConnection.entity.Movie;
import com.practiceankit.basic.databaseConnection.jdbc.MovieJdbcDao;


//@SpringBootApplication
public class JdbcConnectionApplication implements CommandLineRunner {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	MovieJdbcDao dao;
	public static void main(String[] args)  {
		SpringApplication.run(JdbcConnectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
	logger.info("\n List of Movies {} "	,dao.findAll() );
	logger.info("\n List of Movies id 101 {} "	,dao.findById(101) );
	logger.info("\n Inserting Values "	,dao.insertAMovie(new Movie(110,"Robot",800000,"technology")));
	
	logger.info("\n Deleting Values "	,dao.deleteById(104));
		
	}

}
