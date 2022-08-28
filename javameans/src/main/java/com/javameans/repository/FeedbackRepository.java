package com.javameans.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javameans.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {

}
