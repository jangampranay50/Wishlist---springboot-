package com.cg.oems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.oems.dao.WishlistDao;
import com.cg.oems.entity.Wishlist;
import com.cg.oems.exception.WishlistException;

@Service
public class WishlistServiceImpl implements WishlistService{

	@Autowired
	private WishlistDao wishlistDao;

	@Override
	public List<Wishlist> listAllProductsInWishlist() throws WishlistException {
		List<Wishlist> list = wishlistDao.listAllProductsInWishlist();
		if(list.isEmpty())
		{
			throw new WishlistException("Wishlist Empty");
		}
		return list;
	}

	@Override
	public Wishlist addProductToWishlist(Wishlist wishlist) throws WishlistException {
		List<Wishlist> list=wishlistDao.listAllProductsInWishlist();
		for(Wishlist i:list)
		{
			if(i.getProduct().getProductId()==wishlist.getProduct().getProductId())
				throw new WishlistException("Product Already Exist in Wishlist");
		}
		wishlistDao.addProductToWishlist(wishlist);
		return wishlist;
	}

	@Override
	public Wishlist deleteProductByIdInWishlist(int wishlistId) throws WishlistException {
		Wishlist wishlist = wishlistDao.deleteProductByIdInWishlist(wishlistId);
		
		if(wishlist == null)
		{
			throw new WishlistException(wishlistId+" Not Found");
		}
				
		return wishlist;
	}

		
}
