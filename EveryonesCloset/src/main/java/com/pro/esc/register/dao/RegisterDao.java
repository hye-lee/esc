package com.pro.esc.register.dao;

import com.pro.esc.login.UserVO;

public interface RegisterDao {
	
	boolean insertReg(UserVO userVO) throws Exception;
	
	int selectReg(UserVO userVO) throws Exception;

}
