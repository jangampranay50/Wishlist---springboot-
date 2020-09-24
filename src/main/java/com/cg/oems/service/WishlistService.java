package com.cg.oems.service;

import java.util.List;

import com.cg.oems.entity.Wishlist;
import com.cg.oems.exception.WishlistException;

//wishlist service interface
public interface WishlistService {

	public List<Wishlist> listAllProductsInWishlist() throws WishlistException;
	public Wishlist addProductToWishlist(Wishlist wishlist) throws WishlistException;
	public Wishlist deleteProductByIdInWishlist(int wishlistId) throws WishlistException;
	
}
