package com.pro.esc.order.service;

import java.util.HashMap;

import com.pro.esc.cart.dao.CartDTO;
import com.pro.esc.order.dao.OrderDTO;
import com.pro.esc.order.dao.OrderProductDTO;

public interface OrderService {
	void insertOrder(OrderDTO orderDTO)throws Exception;
	
	void insertOrderPro(OrderProductDTO orProDTO)throws Exception;
	
	CartDTO selectOrderProduct(int cartSeq) throws Exception;
	
	int existOrder(HashMap<String, Object> map)throws Exception;
}
