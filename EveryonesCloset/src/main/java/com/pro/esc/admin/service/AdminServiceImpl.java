package com.pro.esc.admin.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.esc.admin.dao.AdminDao;
import com.pro.esc.inquiry.dao.InquiryDTO;
import com.pro.esc.login.dao.UserDTO;
import com.pro.esc.order.dao.OrderDTO;
import com.pro.esc.shop.dao.ProductDTO;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminDao adminDao;

	@Override
	public List<UserDTO> selectAllUser(String userID) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.selectAllUser(userID);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public int updateUserStat(String userID) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.updateUserStat(userID);
	}

	@Override
	public List<ProductDTO> selectAllProduct() throws Exception {
		// TODO Auto-generated method stub
		return adminDao.selectAllProduct();
	}

	@Override
	public int countInquiry() throws Exception {
		// TODO Auto-generated method stub
		return adminDao.countInquiry();
	}

	@Override
	public List<InquiryDTO> selectAllInquiry(HashMap<String,Object> map) throws Exception {
		// TODO Auto-generated method stub
		return adminDao.selectAllInquiry(map);
	}

	@Override
	public int countOrder() throws Exception {
		// TODO Auto-generated method stub
		return adminDao.countOrder();
	}

	@Override
	public List<OrderDTO> selectAllOrder() throws Exception {
		// TODO Auto-generated method stub
		return adminDao.selectAllOrder();
	}
	
	
	
}
