package com.cg.oems.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.oems.entity.Product;
import com.cg.oems.exception.ProductException;

//product dao implementation class implements product dao interface
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	//listing all products
	@Override
	public List<Product> listAllProducts() throws ProductException {
		String qry = "SELECT p FROM Product p";
		TypedQuery<Product> query = entityManager.createQuery(qry,Product.class);
		List<Product> list = query.getResultList();
		return list;
	}

	//finding a product by its ID
	@Override
	public Product findProductById(int productId) throws ProductException {
		Product product = entityManager.find(Product.class, productId);
		return product;
	}
}
