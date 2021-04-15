package com.pro.esc.login.service;

import com.pro.esc.login.UserVO;

public interface LoginService {
	int login(UserVO userVO) throws Exception;
}
