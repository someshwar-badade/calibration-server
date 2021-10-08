package com.examserver.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examserver.model.Question;
import com.examserver.model.Quiz;

public interface QuestionRepository extends JpaRepository<Question, Long> {

	Set<Question> findByQuiz(Quiz quiz);

}
