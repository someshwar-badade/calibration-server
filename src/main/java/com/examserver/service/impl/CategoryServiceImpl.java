package com.examserver.service.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examserver.model.Category;
import com.examserver.repository.CategoryRepository;
import com.examserver.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category addCategory(Category category) {
		return this.categoryRepository.save(category);
	}

	@Override
	public Category updateCategory(Category category) {
		return this.categoryRepository.save(category);
	}

	@Override
	public Set<Category> getCategories() {
		return new LinkedHashSet<Category>(this.categoryRepository.findAll());
	}

	@Override
	public Category getCategory(Long id) {
		return this.categoryRepository.findById(id).get();
	}

	@Override
	public void deleteCategory(Long id) {
		this.categoryRepository.deleteById(id);
		
	}

}
