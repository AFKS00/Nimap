package com.nimap.Entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="product")
public class Product {

	
	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long Product_id;
	    @Column
	    private String Product_name;
        @Column
	    private double Product_price;

	    @ManyToOne
	    @JoinColumn(name = "category_id")
	    private Category category;

	    
		@Override
		public String toString() {
			return "Product [Product_id=" + Product_id + ", Product_name=" + Product_name + ", Product_price="
					+ Product_price + ", category=" + category + "]";
		}

		public Long getProduct_id() {
			return Product_id;
		}

		public void setProduct_id(Long product_id) {
			Product_id = product_id;
		}

		public String getProduct_name() {
			return Product_name;
		}

		public void setProduct_name(String product_name) {
			Product_name = product_name;
		}

		public double getProduct_price() {
			return Product_price;
		}

		public void setProduct_price(double product_price) {
			Product_price = product_price;
		}

		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		@Override
		public int hashCode() {
			return Objects.hash(Product_id, Product_name, Product_price, category);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Product other = (Product) obj;
			return Objects.equals(Product_id, other.Product_id) && Objects.equals(Product_name, other.Product_name)
					&& Double.doubleToLongBits(Product_price) == Double.doubleToLongBits(other.Product_price)
					&& Objects.equals(category, other.category);
		}

		public Product(Long product_id, String product_name, double product_price, Category category) {
			
			Product_id = product_id;
			Product_name = product_name;
			Product_price = product_price;
			this.category = category;
		}

		public Product() {
			
		}

		


}
