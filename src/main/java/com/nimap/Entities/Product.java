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
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Pid")
    private Long Pid;
    @Column(name="Pname")
    private String Pname;
    @Column(name="Pprice")
    private double Pprice;
    
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    
    public Product(Long pid, String pname, double pprice, Category category) {
		super();
		Pid = pid;
		Pname = pname;
		Pprice = pprice;
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [Pid=" + Pid + ", Pname=" + Pname + ", Pprice=" + Pprice + ", category=" + category + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Pid, Pname, Pprice, category);
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
		return Objects.equals(Pid, other.Pid) && Objects.equals(Pname, other.Pname)
				&& Double.doubleToLongBits(Pprice) == Double.doubleToLongBits(other.Pprice)
				&& Objects.equals(category, other.category);
	}

	public Long getPid() {
		return Pid;
	}

	public void setPid(Long pid) {
		Pid = pid;
	}

	public String getPname() {
		return Pname;
	}

	public void setPname(String pname) {
		Pname = pname;
	}

	public double getPprice() {
		return Pprice;
	}

	public void setPprice(double pprice) {
		Pprice = pprice;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	

		public Product() {
			
		}

		


}
