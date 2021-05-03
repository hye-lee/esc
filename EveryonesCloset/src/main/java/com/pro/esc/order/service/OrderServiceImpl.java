package com.pro.esc.order.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.esc.cart.dao.CartDTO;
import com.pro.esc.order.dao.OrderDTO;
import com.pro.esc.order.dao.OrderDao;
import com.pro.esc.order.dao.OrderProductDTO;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDao orderDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void insertOrder(OrderDTO orderDTO) throws Exception {
		// TODO Auto-generated method stub
		orderDao.insertOrder(orderDTO);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void insertOrderPro(OrderProductDTO orProDTO) throws Exception {
		// TODO Auto-generated method stub
		orderDao.insertOrderPro(orProDTO);
	}

	@Override
	public CartDTO selectOrderProduct(int cartSeq) throws Exception {
		// TODO Auto-generated method stub
		return orderDao.selectOrderProduct(cartSeq);
	}

	@Override
	public int existOrder(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return orderDao.existOrder(map);
	}

	
}
