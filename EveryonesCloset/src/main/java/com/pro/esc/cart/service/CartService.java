package com.pro.esc.cart.service;

import java.util.List;

import com.pro.esc.cart.dao.CartDTO;

public interface CartService {
	
	void insertCart(CartDTO cartDTO)throws Exception;
	
	List<CartDTO> selectMyCart(String userID) throws Exception;
	
	int deleteCartOne(CartDTO cartDTO)throws Exception;
	
	int existCart(CartDTO cartDTO)throws Exception;
	
	Integer totalCartPrice(String userID) throws Exception;
}
