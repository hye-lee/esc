package com.pro.esc.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.esc.login.dao.LoginDao;
import com.pro.esc.login.dao.UserDTO;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDao loginDao;
	
	@Override
	public int login(UserDTO userDTO) throws Exception {
		return loginDao.login(userDTO);
	}

}
