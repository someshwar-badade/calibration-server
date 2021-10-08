package com.examserver.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examserver.model.Question;
import com.examserver.model.Quiz;
import com.examserver.repository.QuestionRepository;
import com.examserver.service.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	@Override
	public Question addQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		return this.questionRepository.save(question);
	}

	@Override
	public Set<Question> getQuestion() {
		return new HashSet<Question>(this.questionRepository.findAll());
	}

	@Override
	public Question getQuestion(Long id) {
		return this.questionRepository.findById(id).get();
	}

	@Override
	public void deleteQuestion(Long id) {
		 this.questionRepository.deleteById(id);

	}

	@Override
	public Set<Question> getQuestionOfQuiz(Quiz quiz) {
		return this.questionRepository.findByQuiz(quiz);
	}

}
