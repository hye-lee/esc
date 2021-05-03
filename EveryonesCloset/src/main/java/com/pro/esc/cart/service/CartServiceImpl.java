package com.pro.esc.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.esc.cart.dao.CartDTO;
import com.pro.esc.cart.dao.CartDao;

@Service
public class CartServiceImpl implements CartService{

	@Autowired
	private CartDao cartDao;
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void insertCart(CartDTO cartDTO) throws Exception {
		// TODO Auto-generated method stub
		cartDao.insertCart(cartDTO);
	}

	@Override
	public List<CartDTO> selectMyCart(String userID) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.selectMyCart(userID);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public int deleteCartOne(CartDTO cartDTO) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.deleteCartOne(cartDTO);
	}

	@Override
	public int existCart(CartDTO cartDTO) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.existCart(cartDTO);
	}

	@Override
	public Integer totalCartPrice(String userID) throws Exception {
		// TODO Auto-generated method stub
		return cartDao.totalCartPrice(userID);
	}

}
