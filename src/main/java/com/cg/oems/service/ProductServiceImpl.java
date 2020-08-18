package com.cg.oems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oems.dao.ProductDao;
import com.cg.oems.entity.Product;
import com.cg.oems.exception.ProductException;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> listAllProducts() throws ProductException {
		List<Product> list = productDao.listAllProducts();
		if(list.isEmpty())
		{
			throw new ProductException("Wishlist Empty");
		}
		return list;
	}

	@Override
	public Product findProductById(int productId) throws ProductException {
		Product product = productDao.findProductById(productId);
		
		if(product == null)
		{
			throw new ProductException(productId+" Id Not Found");
		}
				
		return product;
	}

}
