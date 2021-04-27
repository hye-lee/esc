package com.pro.esc.order.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.esc.cart.dao.CartDTO;

@Repository
public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertOrder(OrderDTO orderDTO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.getMapper(OrderDao.class).insertOrder(orderDTO);
	}

	@Override
	public void insertOrderPro(OrderProductDTO orProDTO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.getMapper(OrderDao.class).insertOrderPro(orProDTO);
	}

	@Override
	public CartDTO selectOrderProduct(int cartSeq) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(OrderDao.class).selectOrderProduct(cartSeq);
	}

	@Override
	public int existOrder(HashMap<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(OrderDao.class).existOrder(map);
	}
	
	
}
