package com.pro.esc.admin.dao;

import java.util.HashMap;
import java.util.List;

import com.pro.esc.inquiry.dao.InquiryDTO;
import com.pro.esc.login.dao.UserDTO;
import com.pro.esc.order.dao.OrderDTO;
import com.pro.esc.shop.dao.ProductDTO;

public interface AdminDao {
	List<UserDTO> selectAllUser(String userID) throws Exception;
	
	int updateUserStat(String userID)throws Exception;
	
	List<ProductDTO> selectAllProduct()throws Exception;
	
	int countInquiry()throws Exception;
	
	List<InquiryDTO> selectAllInquiry(HashMap<String,Object> map)throws Exception;
	
	int countOrder() throws Exception;
	
	List<OrderDTO> selectAllOrder()throws Exception;
}


