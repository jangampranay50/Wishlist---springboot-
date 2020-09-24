package com.cg.oems.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.oems.entity.Wishlist;
import com.cg.oems.exception.WishlistException;

//wishlist dao implementation class implements wishlist dao interface
@Repository
@Transactional
public class WishlistDaoImpl implements WishlistDao{

	@PersistenceContext
	private EntityManager entityManager;
	
	//listing all products in wishlist
	@Override
	public List<Wishlist> listAllProductsInWishlist() throws WishlistException {
		String qry = "SELECT w FROM Wishlist w";
		TypedQuery<Wishlist> query = entityManager.createQuery(qry,Wishlist.class);
		List<Wishlist> list = query.getResultList();
		return list;
	}

	//adding a product to wishlist
	@Override
	public Wishlist addProductToWishlist(Wishlist wishlist) throws WishlistException {
		entityManager.persist(wishlist);
		return wishlist;
	}

	//removing a product from wishlist
	@Override
	public Wishlist deleteProductByIdInWishlist(int wishlistId) throws WishlistException {
		Wishlist wishlist = entityManager.find(Wishlist.class, wishlistId);
		if(wishlist!=null)
		{
			entityManager.remove(wishlist);
		}
		return wishlist;
	}

	
}
