package com.example.demo.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.serviceI.CategoryserviceI;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryserviceI categoryService;

    @GetMapping
    public Page<Category> getAllCategories(Pageable pageable) {
        return categoryService.getAllCategories(pageable); 
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return categoryService.getCategoryById(id);
    }	

    @PostMapping
    public Category makeCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public Category UpgradeCategorybyid(@PathVariable Long id, @RequestBody Category category) {
        return categoryService.updateCategory(id, category);
    }

    @DeleteMapping("/{id}")
    public void removeCategoryByid(@PathVariable Long id) {
        categoryService.deleteCategory(id);
    }
}

