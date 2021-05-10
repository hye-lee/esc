package com.pro.esc.admin.service;

import java.util.HashMap;
import java.util.List;

import com.pro.esc.inquiry.dao.InquiryDTO;
import com.pro.esc.login.dao.UserDTO;
import com.pro.esc.shop.dao.ProductDTO;

public interface AdminService {
	
	List<UserDTO> selectAllUser (String userID) throws Exception;
	
	int updateUserStat(String userID)throws Exception;
	
	List<ProductDTO> selectAllProduct()throws Exception;
	
	int countInquiry()throws Exception;
	
	List<InquiryDTO> selectAllInquiry(HashMap<String,Object> map)throws Exception;

}
