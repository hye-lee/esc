package com.pro.esc.login.dao;

import com.pro.esc.login.UserVO;

public interface LoginDao {
	
	int login(UserVO userVO) throws Exception;

}
