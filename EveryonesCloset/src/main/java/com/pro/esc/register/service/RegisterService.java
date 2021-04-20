package com.pro.esc.register.service;

import com.pro.esc.login.dao.UserDTO;

public interface RegisterService {
	
	boolean insertReg(UserDTO userDTO) throws Exception;

	int selectReg(UserDTO userDTO) throws Exception;

}
