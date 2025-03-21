package com.nimap.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimap.Entities.Product;
import com.nimap.repositorys.ProductRepository;


@Service
public class ProductServices {

	@Autowired
	private ProductRepository productRepo; 
	
	public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public Product updateProduct(Long id, Product updatedProduct) {
        Product existingProduct = productRepo.findById(id).orElse(null);
        if (existingProduct != null) {
            existingProduct.setProduct_name(updatedProduct.getProduct_name());
            existingProduct.setProduct_price(updatedProduct.getProduct_price());
            existingProduct.setCategory(updatedProduct.getCategory());
            return productRepo.save(existingProduct);
        }
        return null;
    }

    public void deleteProduct(Long id) {
    	productRepo.deleteById(id);
    }
    
	public ProductServices() {
		// TODO Auto-generated constructor stub
	}

}
