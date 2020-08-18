package com.cg.oems.dao;

import java.util.List;

import com.cg.oems.entity.Product;
import com.cg.oems.exception.ProductException;

public interface ProductDao {

	public List<Product> listAllProducts() throws ProductException;
	public Product findProductById(int productId) throws ProductException;
}
