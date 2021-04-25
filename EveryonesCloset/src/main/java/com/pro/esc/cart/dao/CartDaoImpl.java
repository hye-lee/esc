package com.pro.esc.cart.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDaoImpl implements CartDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void insertCart(CartDTO cartDTO) throws Exception{
		sqlSession.getMapper(CartDao.class).insertCart(cartDTO);
	}

	@Override
	public List<CartDTO> selectMyCart(String userID) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(CartDao.class).selectMyCart(userID);
	}

	@Override
	public int deleteCartOne(CartDTO cartDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(CartDao.class).deleteCartOne(cartDTO);
	}

	@Override
	public int existCart(CartDTO cartDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(CartDao.class).existCart(cartDTO);
	}

	@Override
	public Integer totalCartPrice(String userID) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(CartDao.class).totalCartPrice(userID);
	}

}
