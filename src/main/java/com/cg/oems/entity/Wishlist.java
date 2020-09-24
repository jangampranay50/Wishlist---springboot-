package com.cg.oems.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//wishlist entity class
@Entity
@Table(name="wishlist_tbl")
public class Wishlist {
	
	@Id
	@GeneratedValue(generator="seq",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="seq",sequenceName="product_wishlist_seq",allocationSize=1)
	@Column(name="wishlist_id")
    private int wishlistId;
	
	//mapping product
	@ManyToOne
	@JoinColumn(name="product_id")
	private Product  product;

	//getters and setters
	public int getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(int wishlistId) {
		this.wishlistId = wishlistId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
		

}
