package com.examserver.service;

import java.util.Set;

import com.examserver.model.Quiz;


public interface QuizService {

	public Quiz addQuiz(Quiz quiz);
	public Quiz updateQuiz(Quiz quiz);
	public Set<Quiz> getQuizzes();
	public Quiz getQuiz(Long id);
	public void deleteQuiz(Long id);
}
