package com.examserver.service;

import java.util.Set;

import com.examserver.model.Category;

public interface CategoryService {

	public Category addCategory(Category category);
	public Category updateCategory(Category category);
	public Set<Category> getCategories();
	public Category getCategory(Long id);
	public void deleteCategory(Long id);
}
