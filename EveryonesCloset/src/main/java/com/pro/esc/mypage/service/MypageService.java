package com.pro.esc.mypage.service;

import java.util.HashMap;
import java.util.List;

import com.pro.esc.inquiry.dao.InquiryDTO;
import com.pro.esc.login.dao.UserDTO;
import com.pro.esc.mypage.dao.MyOrderDTO;
import com.pro.esc.order.dao.OrderDTO;

public interface MypageService {
	
	UserDTO selectUserOne(String userID)throws Exception;

	String checkUserPw(HashMap<String, String> map) throws Exception;
	
	int updateUserStat(String userID)throws Exception;
	
	List<InquiryDTO> selectMyInquiry(InquiryDTO inquiryDTO)throws Exception;
	
	int countMyInquiry(String userID)throws Exception;
	
	List<OrderDTO> selectMyOrder(OrderDTO orderDTO) throws Exception;
	
	int countMyOrder(String userID)throws Exception;
	
	List<MyOrderDTO> selectOrderDetail(HashMap<String,String> map) throws Exception;
	
	OrderDTO selectOrderDetailRec(String ordSeq)throws Exception;
}
