package com.pro.esc.admin.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.esc.login.dao.UserDTO;
import com.pro.esc.shop.dao.ProductDTO;

@Repository
public class AdminDaoImpl implements AdminDao{

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<UserDTO> selectAllUser(String userID) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(AdminDao.class).selectAllUser(userID);
	}

	@Override
	public int updateUserStat(String userID) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(AdminDao.class).updateUserStat(userID);
	}

	@Override
	public List<ProductDTO> selectAllProduct() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(AdminDao.class).selectAllProduct();
	}
	
	
}
