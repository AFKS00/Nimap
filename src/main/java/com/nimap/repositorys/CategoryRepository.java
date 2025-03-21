package com.nimap.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.Entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
