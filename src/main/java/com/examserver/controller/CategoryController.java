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

import com.examserver.model.Category;
import com.examserver.service.CategoryService;


@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	//get all categories
	@GetMapping
	public ResponseEntity<?> getCategories(){
		return ResponseEntity.ok(this.categoryService.getCategories());
	}
	
	//get category
	@GetMapping("/{id}")
	public ResponseEntity<?> getCategory(@PathVariable("id") Long id){
		return ResponseEntity.ok(this.categoryService.getCategory(id));
	}
	
	//create category
	@PostMapping
	public Category addCategory(@RequestBody Category category) {
		return this.categoryService.addCategory(category);
	}
	
	//Update category
	@PutMapping
	public Category getCategoryDetails(@RequestBody Category category) {
		return this.categoryService.updateCategory(category);
	}
	
	//get category
	@DeleteMapping("/{id}")
	public void deleteCategory(@PathVariable("id") Long id){
		this.categoryService.deleteCategory(id);
	}
	
}
