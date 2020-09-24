package com.cg.oems.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

//product entity class
@Entity
@Table(name="product_tbl")
public class Product {
	@Id
	@GeneratedValue(generator="seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq",sequenceName="product_seq",allocationSize=1)
	@Column(name="product_id")
	private int productId;
	
	@Column(name="product_name",length=15)
	private String productName;
	
	@Column(name="product_info",length=60)
	private String productInfo;
	
	@Column(name="product_price")
	private double price;
	
	//mapping category 
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category  category;
	
	//mapping retailer 
	@ManyToOne
	@JoinColumn(name="retailer_id")
	private Retailer  retailer;

	//getters and setters
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(String productInfo) {
		this.productInfo = productInfo;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}

//	public List<Wishlist> getWishlist() {
//		return wishlist;
//	}
//
//	public void setWishlist(List<Wishlist> wishlist) {
//		this.wishlist = wishlist;
//	}
//	

}
