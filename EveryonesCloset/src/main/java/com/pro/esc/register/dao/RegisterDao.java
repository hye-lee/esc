package com.pro.esc.register.dao;

import com.pro.esc.login.dao.UserDTO;

public interface RegisterDao {
	
	boolean insertReg(UserDTO userDTO) throws Exception;
	
	int selectReg(UserDTO userDTO) throws Exception;

}
