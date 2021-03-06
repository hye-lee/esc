package com.pro.esc.admin.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pro.esc.inquiry.dao.InquiryDTO;
import com.pro.esc.login.dao.UserDTO;
import com.pro.esc.order.dao.OrderDTO;
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
	public List<ProductDTO> selectAllProduct(HashMap<String,Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(AdminDao.class).selectAllProduct(map);
	}

	@Override
	public int countInquiry() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(AdminDao.class).countInquiry();
	}

	@Override
	public List<InquiryDTO> selectAllInquiry(HashMap<String,Object> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(AdminDao.class).selectAllInquiry(map);
	}

	@Override
	public int countOrder() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(AdminDao.class).countOrder();
	}

	@Override
	public List<OrderDTO> selectAllOrder() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(AdminDao.class).selectAllOrder();
	}

	@Override
	public int countProduct() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(AdminDao.class).countProduct();
	}
	
	
}
