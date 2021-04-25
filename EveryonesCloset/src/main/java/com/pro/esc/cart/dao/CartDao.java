package com.pro.esc.cart.dao;

import java.util.List;

public interface CartDao {
	
	void insertCart(CartDTO cartDTO)throws Exception;
	
	List<CartDTO> selectMyCart(String userID)throws Exception;
	
	int deleteCartOne(CartDTO cartDTO)throws Exception;
	
	int existCart(CartDTO cartDTO)throws Exception;
	
	Integer totalCartPrice(String userID) throws Exception;
}
