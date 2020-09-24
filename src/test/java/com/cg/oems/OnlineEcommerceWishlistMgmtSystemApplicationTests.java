package com.cg.oems;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.oems.dao.ProductDao;
import com.cg.oems.dao.WishlistDao;
import com.cg.oems.entity.Product;
import com.cg.oems.entity.Wishlist;
import com.cg.oems.exception.ProductException;
import com.cg.oems.exception.WishlistException;

//test class
@SpringBootTest
class OnlineEcommerceWishlistMgmtSystemApplicationTests {

	@Autowired
	ProductDao productDao;
	
	@Autowired
	WishlistDao wishlistDao;
	
	//testing search product by Id
	@Test
	void testProductByIdExist() throws ProductException {
		Product product = productDao.findProductById(201);
		assertNotNull(product);
	}
	
	//testing search product by Id failure case
	@Test
	void testProductByIdNotExist() throws ProductException{
		Product product = productDao.findProductById(101);
		assertNull(product);
	}	
	
	//testing list all products 
	@Test
	void testListAllProducts() throws ProductException
	{
		List<Product> products = productDao.listAllProducts();
		assertNotNull(products);
	}
	
	//testing delete product in wishlist by Id
	@Test
	void testRemoveProductInWishlistById() throws WishlistException
	{
		Wishlist wishlist = wishlistDao.deleteProductByIdInWishlist(7131);
		assertNotNull(wishlist);
	}
	
	//testing delete product in wishlist by Id failure case
	@Test
	void testRemoveProductInWishlistByIdNotExist() throws WishlistException
	{
		Wishlist wishlist = wishlistDao.deleteProductByIdInWishlist(7000);
		assertNull(wishlist);
	}
	
	//testing list all products in wishlist
	@Test
	void testListAllProductsInWishlist() throws WishlistException
	{
		List<Wishlist> wishlist = wishlistDao.listAllProductsInWishlist();
		assertNotNull(wishlist);
	}

}
