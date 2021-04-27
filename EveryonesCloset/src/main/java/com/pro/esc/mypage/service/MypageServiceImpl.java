package com.pro.esc.mypage.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
