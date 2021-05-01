package com.pro.esc.mypage.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.esc.inquiry.dao.InquiryDTO;
import com.pro.esc.login.dao.UserDTO;
import com.pro.esc.mypage.dao.MypageDao;

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
	
}
