package com.cg.oems.dao;

import java.util.List;

import com.cg.oems.entity.Wishlist;
import com.cg.oems.exception.WishlistException;

//wishlist dao interface
public interface WishlistDao {

	public List<Wishlist> listAllProductsInWishlist() throws WishlistException;
	public Wishlist addProductToWishlist(Wishlist wishlist) throws WishlistException;
	public Wishlist deleteProductByIdInWishlist(int wishlistId) throws WishlistException;
	
}
