package com.pro.esc.order.dao;

import java.util.HashMap;

import com.pro.esc.cart.dao.CartDTO;

public interface OrderDao {
	void insertOrder(OrderDTO orderDTO)throws Exception;
	
	void insertOrderPro(OrderProductDTO orProDTO)throws Exception;
	
	CartDTO selectOrderProduct(int cartSeq) throws Exception;
	
	int existOrder(HashMap<String, Object> map) throws Exception;
}
