package com.cg.oems.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="retailer_tbl")
public class Retailer {
	@Id
	@GeneratedValue(generator="seq",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="seq",sequenceName="product_retailer_seq",allocationSize=1)
	@Column(name="retailer_id")
	private int retailorId;
	
	@Column(name="retailer_name")
	private String retailerName;
	
	@Column(name="retailer_location")
	private String retailerLocation;
	
//	@OneToMany(mappedBy="retailer")
//	@JsonIgnore
//	private List<Product>  Product=new ArrayList<Product>();

	public int getRetailorId() {
		return retailorId;
	}

	public void setRetailorId(int retailorId) {
		this.retailorId = retailorId;
	}

	public String getRetailerName() {
		return retailerName;
	}

	public void setRetailerName(String retailerName) {
		this.retailerName = retailerName;
	}

	public String getRetailerLocation() {
		return retailerLocation;
	}

	public void setRetailerLocation(String retailerLocation) {
		this.retailerLocation = retailerLocation;
	}

//	public List<Product> getProduct() {
//		return Product;
//	}
//
//	public void setProduct(List<Product> product) {
//		Product = product;
//	}

	

}
