package com.cg.oems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.oems.entity.Product;
import com.cg.oems.entity.Wishlist;
import com.cg.oems.exception.ProductException;
import com.cg.oems.exception.WishlistException;
import com.cg.oems.service.ProductService;
import com.cg.oems.service.WishlistService;

@RestController
@CrossOrigin("*")
public class WishlistController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private WishlistService wishlistService;
	
	@GetMapping("product/{pid}")
	public ResponseEntity<Product> findProductById(@PathVariable("pid") int productId) throws ProductException 
	{
		Product product=null;
	
		product = productService.findProductById(productId);
		
		ResponseEntity<Product> response = new ResponseEntity(product,HttpStatus.OK);

		return response;
	}
	
	@GetMapping("product")
	public ResponseEntity<List<Product>> listAllProducts() throws ProductException
	{
		List<Product> list = productService.listAllProducts();
		ResponseEntity<List<Product>> response = new ResponseEntity<>(list,HttpStatus.OK);
		return response; 
	}
	
	@GetMapping("wishlist")
	public ResponseEntity<List<Wishlist>> listAllProductsInWishlist() throws WishlistException
	{
		List<Wishlist> list = wishlistService.listAllProductsInWishlist();
		ResponseEntity<List<Wishlist>> response = new ResponseEntity<>(list,HttpStatus.OK);
		return response;
	}
	
	@PostMapping("wishlist")
	public ResponseEntity<Wishlist> addProductToWishlist(@RequestBody Wishlist wishlist) throws WishlistException
	{
		Wishlist w = wishlistService.addProductToWishlist(wishlist);
		ResponseEntity<Wishlist> response = new ResponseEntity(w,HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("wishlist/{wid}")
	public ResponseEntity<Wishlist> deleteProductInWishlist(@PathVariable("wid") int wishlistId) throws WishlistException
	{
		Wishlist w = wishlistService.deleteProductByIdInWishlist(wishlistId);
		ResponseEntity<Wishlist> response = new ResponseEntity(w,HttpStatus.OK);
		return response;
	}
	
		
}
