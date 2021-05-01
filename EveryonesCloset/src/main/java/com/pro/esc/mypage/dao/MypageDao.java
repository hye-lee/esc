package com.pro.esc.mypage.dao;

import java.util.HashMap;
import java.util.List;

import com.pro.esc.inquiry.dao.InquiryDTO;
import com.pro.esc.login.dao.UserDTO;

public interface MypageDao {
	UserDTO selectUserOne(String userID)throws Exception;
	
	String checkUserPw(HashMap<String, String> map)throws Exception;
	
	int updateUserStat(String userID)throws Exception;
	
	List<InquiryDTO> selectMyInquiry(InquiryDTO inquiryDTO)throws Exception;
	
	int countMyInquiry(String userID)throws Exception;
}
