package com.examserver.service;

import java.util.Set;

import com.examserver.model.Question;
import com.examserver.model.Quiz;



public interface QuestionService {
	public Question addQuestion(Question question);
	public Question updateQuestion(Question question);
	public Set<Question> getQuestion();
	public Question getQuestion(Long id);
	public Set<Question> getQuestionOfQuiz(Quiz quiz);
	public void deleteQuestion(Long id);
}
