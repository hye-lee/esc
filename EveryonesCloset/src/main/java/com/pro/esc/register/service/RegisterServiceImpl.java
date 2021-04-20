package com.pro.esc.register.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.esc.login.dao.UserDTO;
import com.pro.esc.register.dao.RegisterDao;

@Service
@Transactional(readOnly = true)
public class RegisterServiceImpl implements RegisterService{
	
	@Autowired
	private RegisterDao registerDao;
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public boolean insertReg(UserDTO userDTO) throws Exception {
		try {
			registerDao.insertReg(userDTO);
		}catch(Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}
	
	@Override
	public int selectReg(UserDTO userDTO)throws Exception {
		
		return registerDao.selectReg(userDTO);
	}

}
