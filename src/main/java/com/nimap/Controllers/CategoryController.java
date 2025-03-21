package com.nimap.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.Entities.Category;
import com.nimap.Services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService catser;
	
	@GetMapping
    public List<Category> getAllCategories() {
        return catser.getAllCategories();
    }

    @GetMapping("/{id}")
    public Category getCategoryById(@PathVariable Long id) {
        return catser.getCategoryById(id);
    }

    @PostMapping
    public Category addCategory(@RequestBody Category category) {
        return catser.addCategory(category);
    }

    @PutMapping("/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category updatedCategory) {
        return catser.updateCategory(id, updatedCategory);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
    	catser.deleteCategory(id);
    }
	

	public CategoryController() {
		// TODO Auto-generated constructor stub
	}

}
