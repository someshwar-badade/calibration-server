package com.examserver.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examserver.model.Question;
import com.examserver.model.Quiz;
import com.examserver.service.QuestionService;
import com.examserver.service.QuizService;

@RestController
@RequestMapping("/question")
@CrossOrigin("*")
public class QuestionController {

	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private QuizService quizService;
	
	@GetMapping
	public ResponseEntity<?> getAllQuestions(){
		return ResponseEntity.ok(this.questionService.getQuestion());
	}
	
	@GetMapping("/quiz/{quiz_id}")
	public ResponseEntity<?> getQuestionsOfQuiz(@PathVariable("quiz_id") Long quiz_id){
		//		Quiz quiz = new Quiz();
		//		quiz.setId(quiz_id);
		//		Set<Question> questionsOfQuiz = this.questionService.getQuestionOfQuiz(quiz);
		//		return ResponseEntity.ok(questionsOfQuiz);
		
		Quiz quiz = this.quizService.getQuiz(quiz_id);
		Set<Question> questions = quiz.getQuestions();
		List<?> list = new ArrayList<>(questions);
		Integer numberOfQuestions = Integer.parseInt(quiz.getNumberOfQuestions());
		if(list.size()>numberOfQuestions) {
			list = list.subList(0, numberOfQuestions+1);
		}
		java.util.Collections.shuffle(list);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/{id}")
	public Question getQuestion(@PathVariable Long id){
		return this.questionService.getQuestion(id);
	}
	
	@PostMapping
	public Question addQuestion(@RequestBody Question question) {
		return this.questionService.addQuestion(question);
	}
	
	@PutMapping
	public Question updateQuestion(@RequestBody Question question) {
		return this.questionService.updateQuestion(question);
	}
	
	@DeleteMapping("/{id}")
	public void deleteQuestion(@PathVariable("id") Long id) {
		this.questionService.deleteQuestion(id);
	}
	
}
