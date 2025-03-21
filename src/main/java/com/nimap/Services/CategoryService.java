package com.nimap.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.Entities.Category;
import com.nimap.repositorys.CategoryRepository;
@Service
public class CategoryService {

@Autowired
 private CategoryRepository catrepo;
	
	public List<Category> getAllCategories() {
        return catrepo.findAll();
    }

    public Category getCategoryById(Long id) {
        return catrepo.findById(id).orElse(null);
    }

    public Category addCategory(Category category) {
        return catrepo.save(category);
    }

    public Category updateCategory(Long id, Category updatedCategory) {
        Category existingCategory = catrepo.findById(id).orElse(null);
        if (existingCategory != null) {
            existingCategory.setName(updatedCategory.getName());
            return catrepo.save(existingCategory);
        }
        return null;
    }

    public void deleteCategory(Long id) {
    	catrepo.deleteById(id);
    }
 
	public CategoryService() {
		// TODO Auto-generated constructor stub
	}

}
