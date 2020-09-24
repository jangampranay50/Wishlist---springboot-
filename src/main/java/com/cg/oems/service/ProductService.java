package com.cg.oems.service;

import java.util.List;

import com.cg.oems.entity.Product;
import com.cg.oems.exception.ProductException;

//product service interface
public interface ProductService {

	public List<Product> listAllProducts() throws ProductException;
	public Product findProductById(int productId) throws ProductException;
}
