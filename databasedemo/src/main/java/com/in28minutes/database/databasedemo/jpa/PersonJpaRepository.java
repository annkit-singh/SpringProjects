package com.in28minutes.database.databasedemo.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28minutes.database.databasedemo.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {
	
	//connect to the database
	 @PersistenceUnit
	 EntityManager  entityManager;
	 
	 

	
	public Person findById(int id) {
		
		
		return entityManager.find(Person.class, id);//JPA
	}
}
