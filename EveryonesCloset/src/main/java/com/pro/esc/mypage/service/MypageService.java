package com.pro.esc.mypage.service;

import java.util.HashMap;

import com.pro.esc.login.dao.UserDTO;

public interface MypageService {
	
	UserDTO selectUserOne(String userID)throws Exception;

	String checkUserPw(HashMap<String, String> map) throws Exception;
}
