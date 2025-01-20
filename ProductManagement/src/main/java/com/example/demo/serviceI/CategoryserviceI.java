package com.example.demo.serviceI;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.demo.model.Category;

public interface CategoryserviceI {
	Page<Category> getAllCategories(Pageable pageable);

	Category getCategoryById(Long id);

	Category createCategory(Category category);

	Category updateCategory(Long id, Category category);

	void deleteCategory(Long id);

}
