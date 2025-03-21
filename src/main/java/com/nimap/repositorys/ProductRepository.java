package com.nimap.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nimap.Entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
