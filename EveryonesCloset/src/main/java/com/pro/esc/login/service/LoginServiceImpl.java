package com.pro.esc.login.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.esc.login.dao.LoginDao;
import com.pro.esc.login.dao.UserDTO;

@Service
@Transactional(readOnly = true)
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDao loginDao;
	
	@Override
	public int login(UserDTO userDTO) throws Exception {
		return loginDao.login(userDTO);
	}

	@Override
	public String findId(HashMap<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return loginDao.findId(map);
	}

	@Override
	public int findPw(HashMap<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return loginDao.findPw(map);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public int updatePw(HashMap<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return loginDao.updatePw(map);
	}

	@Override
	public String selectadmin(UserDTO userDTO) throws Exception {
		// TODO Auto-generated method stub
		return loginDao.selectadmin(userDTO);
	}

}
