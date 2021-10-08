package com.examserver.controller;

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

import com.examserver.model.Quiz;
import com.examserver.service.QuizService;

@RestController
@RequestMapping("/quiz")
@CrossOrigin("*")
public class QuizController {
	
	@Autowired
	private QuizService quizService;
	
	@GetMapping
	public ResponseEntity<?> getAllQuiz(){
		return ResponseEntity.ok(this.quizService.getQuizzes());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getQuiz(@PathVariable("id") Long id){
		return ResponseEntity.ok(this.quizService.getQuiz(id));
	}
	
	@PostMapping
	public Quiz addQuiz(@RequestBody Quiz quiz) {
		return this.quizService.addQuiz(quiz);
	}
	
	@PutMapping
	public Quiz updateQuiz(@RequestBody Quiz quiz) {
		return this.quizService.updateQuiz(quiz);
	}
	
	@DeleteMapping("/{id}")
	public void deleteQuiz(@PathVariable("id") Long id) {
		this.quizService.deleteQuiz(id);
	}
	
}
