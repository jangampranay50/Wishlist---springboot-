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
import org.springframework.web.client.RestTemplate;

import com.cg.oems.entity.Login;
import com.cg.oems.entity.Product;
import com.cg.oems.entity.ProductList;
import com.cg.oems.entity.Wishlist;
import com.cg.oems.exception.ProductException;
import com.cg.oems.exception.WishlistException;
import com.cg.oems.service.ProductService;
import com.cg.oems.service.WishlistService;

//main controller "wishlist controller"
@RestController
@CrossOrigin("*")
public class WishlistController {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private WishlistService wishlistService;
	
	//get mapping, login
	@GetMapping("wishlist/login/{user}/{pass}")
	public ResponseEntity<String> login(@PathVariable("user") String user,@PathVariable("pass") String pass)
	{
		ResponseEntity<String> re =restTemplate.getForEntity("http://login-service/login/validate/"+user+"/"+pass,String.class);
		return re ;
	}
	
	//get mapping, getting all products 
	@GetMapping("wishlist/product/getallproducts")
	public ResponseEntity<List<Product>> getAllProductList()
	{
		ResponseEntity<ProductList> productList = restTemplate.getForEntity("http://product-service/product",ProductList.class);
		List<Product> list = productList.getBody().getList();
	
		ResponseEntity<List<Product>>  re= new ResponseEntity<>(list,HttpStatus.OK);
		return re;
	}
	
	//get mapping, finding a product by its id
	@GetMapping("wishlist/product/{pid}")
	public ResponseEntity<Product> findProductById(@PathVariable("pid") int productId) throws ProductException 
	{
		Product product=null;
	
		product = productService.findProductById(productId);
		
		ResponseEntity<Product> response = new ResponseEntity(product,HttpStatus.OK);

		return response;
	}
	
	//get mapping, listing all products
	@GetMapping("wishlist/product")
	public ResponseEntity<List<Product>> listAllProducts() throws ProductException
	{
		List<Product> list = productService.listAllProducts();
		ResponseEntity<List<Product>> response = new ResponseEntity<>(list,HttpStatus.OK);
		return response; 
	}
	
	//get mapping, listing all products in wishlist
	@GetMapping("wishlist")
	public ResponseEntity<List<Wishlist>> listAllProductsInWishlist() throws WishlistException
	{
		List<Wishlist> list = wishlistService.listAllProductsInWishlist();
		ResponseEntity<List<Wishlist>> response = new ResponseEntity<>(list,HttpStatus.OK);
		return response;
	}
	
	//post mapping, adding a product to wishlist
	@PostMapping("wishlist")
	public ResponseEntity<Wishlist> addProductToWishlist(@RequestBody Wishlist wishlist) throws WishlistException
	{
		Wishlist w = wishlistService.addProductToWishlist(wishlist);
		ResponseEntity<Wishlist> response = new ResponseEntity(w,HttpStatus.OK);
		return response;
	}
	
	//delete mapping, deleting a product from wishlist
	@DeleteMapping("wishlist/{wid}")
	public ResponseEntity<Wishlist> deleteProductInWishlist(@PathVariable("wid") int wishlistId) throws WishlistException
	{
		Wishlist w = wishlistService.deleteProductByIdInWishlist(wishlistId);
		ResponseEntity<Wishlist> response = new ResponseEntity(w,HttpStatus.OK);
		return response; 
	}
	
		
}
