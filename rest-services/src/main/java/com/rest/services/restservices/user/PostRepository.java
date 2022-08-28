package com.rest.services.restservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.services.restservices.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}