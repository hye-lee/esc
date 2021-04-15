package com.pro.esc.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.esc.login.UserVO;
import com.pro.esc.login.dao.LoginDao;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDao loginDao;
	
	@Override
	public int login(UserVO userVO) {
		return loginDao.login(userVO);
	}

}
