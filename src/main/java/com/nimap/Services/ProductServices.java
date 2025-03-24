package com.nimap.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nimap.Entities.Product;
import com.nimap.repositorys.ProductRepository;


@Service
public class ProductServices {

	@Autowired
	private ProductRepository productRepo; 
	
	public Page<Product> getAllProducts(int page) {
        return productRepo.findAll(PageRequest.of(page, 5));
    }

    public Product getProductById(Long id) {
        return productRepo.findById(id).orElse(null);
    }

    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepo.findById(id).orElse(null);

        if (existingProduct == null) {
            return null; // Return null if product not found (or handle with exception)
        }

        existingProduct.setPname(product.getPname());
        existingProduct.setPprice(product.getPprice());
        existingProduct.setCategory(product.getCategory());

        return productRepo.save(existingProduct);
    }


    public void deleteProduct(Long id) {
    	productRepo.deleteById(id);
    }
    
	public ProductServices() {
		// TODO Auto-generated constructor stub
	}

}
