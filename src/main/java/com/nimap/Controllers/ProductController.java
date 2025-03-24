package com.nimap.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nimap.Entities.Product;
import com.nimap.Services.ProductServices;

@RestController
@RequestMapping("/api/products")
public class ProductController {

	
	    @Autowired
	    private ProductServices productService;

	    @GetMapping
	    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int page) {
	        return productService.getAllProducts(page);
	    }

	    @GetMapping("/getbyid/{id}")
	    public Product getProductById(@PathVariable Long id) {
	        return productService.getProductById(id);
	    }

	    @PostMapping("/add")
	    public Product addProduct(@RequestBody Product product) {
	        return productService.addProduct(product);
	    }

	    @PutMapping("/update/{id}")
	    public Product updateProduct(@PathVariable Long id, @RequestBody Product updatedProduct) {
	        return productService.updateProduct(id, updatedProduct);
	    }

	    @DeleteMapping("/delete/{id}")
	    public void deleteProduct(@PathVariable Long id) {
	        productService.deleteProduct(id);
	    }
	public ProductController() {
		// TODO Auto-generated constructor stub
	}

}
