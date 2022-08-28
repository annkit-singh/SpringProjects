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
import com.practiceankit.basic.databaseConnection.springdata.MovieSpringDataJpaRepository;


@SpringBootApplication
public class SpringDataJPAConnectionApplication implements CommandLineRunner {
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());

	@Autowired
	MovieSpringDataJpaRepository repository;
	public static void main(String[] args)  {
		SpringApplication.run(SpringDataJPAConnectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	// TODO Auto-generated method stub
	logger.info("\n List of Movies {} "	,repository.findById(102));
	
		logger.info("\n List of Movies id 101 {} "	,repository.findAll());
		
		repository.save(new Movie(101,"RRR",5000000,"Revolution"));
		
		repository.save(new Movie(1,"KGF",5000,"Action"));
		
		repository.save(new Movie("MiddleMan",7000,"Secrecy"));
//		logger.info("\n Inserting Values {}"	,repository.(new Movie(120,"Pakistan MKB",1900000,"Sprituality")));
//		logger.info("\n Updating Values {}"	,repository.save(new Movie(1,"Pakistan MKB",1900000,"Informative")));
//		logger.info("\n Deleting Values----   "	);
//		repository.deleteById(101);
		
	}

}
