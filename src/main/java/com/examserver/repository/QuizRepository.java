package com.examserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examserver.model.Quiz;

public interface QuizRepository extends JpaRepository<Quiz, Long>{

}
