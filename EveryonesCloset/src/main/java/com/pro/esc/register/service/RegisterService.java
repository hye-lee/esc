package com.pro.esc.register.service;

import com.pro.esc.login.UserVO;

public interface RegisterService {
	
	boolean insertReg(UserVO userVO);

	int selectReg(UserVO userVO);

}
