package com.nimap.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nimap.Entities.Category;
import com.nimap.repositorys.CategoryRepository;
@Service
public class CategoryService {

@Autowired
 private CategoryRepository catrepo;
	
public Page<Category> getAllCategories(int page) {
    return catrepo.findAll(PageRequest.of(page, 5));
}

    public Category getCategoryById(Long id) {
        return catrepo.findById(id).orElse(null);
    }

    public Category addCategory(Category category) {
        return catrepo.save(category);
    }

    public Category updateCategory(Long id, Category updatedCategory) {
        Category existingCategory = catrepo.findById(id).orElse(null);
        if (existingCategory == null) {
            return null; 
        }
        existingCategory.setName(updatedCategory.getName());
        return catrepo.save(existingCategory);
    }

    public void deleteCategory(Long id) {
    	catrepo.deleteById(id);
    }
 
	public CategoryService() {
		// TODO Auto-generated constructor stub
	}

}
