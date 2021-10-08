package com.examserver.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examserver.model.Quiz;
import com.examserver.repository.QuizRepository;
import com.examserver.service.QuizService;

@Service
public class QuizServiceImpl implements QuizService {

	@Autowired
	private QuizRepository quizRepository;
	
	@Override
	public Quiz addQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		return this.quizRepository.save(quiz);
	}

	@Override
	public Set<Quiz> getQuizzes() {
		return new HashSet<Quiz>(this.quizRepository.findAll());
	}

	@Override
	public Quiz getQuiz(Long id) {
		return this.quizRepository.findById(id).get();
	}

	@Override
	public void deleteQuiz(Long id) {
		 this.quizRepository.deleteById(id);
		
	}

}
