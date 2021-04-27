package com.pro.esc.mypage.service;

import com.pro.esc.login.dao.UserDTO;

public interface MypageService {
	
	UserDTO selectUserOne(String userID)throws Exception;
}
