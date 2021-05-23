package com.pro.esc.mypage.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.esc.inquiry.dao.InquiryDTO;
import com.pro.esc.login.dao.UserDTO;
import com.pro.esc.mypage.dao.MyOrderDTO;
import com.pro.esc.mypage.dao.MypageDao;
import com.pro.esc.order.dao.OrderDTO;

@Service
public class MypageServiceImpl implements MypageService {

	@Autowired
	private MypageDao mypageDao;
	
	@Override
	public UserDTO selectUserOne(String userID) throws Exception {
		// TODO Auto-generated method stub
		return mypageDao.selectUserOne(userID);
	}

	@Override
	public String checkUserPw(HashMap<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return mypageDao.checkUserPw(map);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public int updateUserStat(String userID) throws Exception {
		// TODO Auto-generated method stub
		return mypageDao.updateUserStat(userID);
	}

	@Override
	public List<InquiryDTO> selectMyInquiry(InquiryDTO inquiryDTO) throws Exception {
		// TODO Auto-generated method stub
		return mypageDao.selectMyInquiry(inquiryDTO);
	}

	@Override
	public int countMyInquiry(String userID) throws Exception {
		// TODO Auto-generated method stub
		return mypageDao.countMyInquiry(userID);
	}

	@Override
	public List<OrderDTO> selectMyOrder(OrderDTO orderDTO) throws Exception {
		// TODO Auto-generated method stub
		return mypageDao.selectMyOrder(orderDTO);
	}

	@Override
	public List<MyOrderDTO> selectOrderDetail(HashMap<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return mypageDao.selectOrderDetail(map);
	}

	@Override
	public int countMyOrder(String userID) throws Exception {
		// TODO Auto-generated method stub
		return mypageDao.countMyOrder(userID);
	}

	@Override
	public OrderDTO selectOrderDetailRec(String ordSeq) throws Exception {
		// TODO Auto-generated method stub
		return mypageDao.selectOrderDetailRec(ordSeq);
	}

	@Override
	public int updataUserInfo(UserDTO userDTO) throws Exception {
		// TODO Auto-generated method stub
		return mypageDao.updataUserInfo(userDTO);
	}
	
}
