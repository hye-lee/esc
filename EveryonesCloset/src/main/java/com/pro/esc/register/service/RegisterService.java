package com.pro.esc.register.service;

import com.pro.esc.login.UserVO;

public interface RegisterService {
	
	boolean insertReg(UserVO userVO) throws Exception;

	int selectReg(UserVO userVO) throws Exception;

}
