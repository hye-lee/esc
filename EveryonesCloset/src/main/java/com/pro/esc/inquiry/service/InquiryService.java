package com.pro.esc.inquiry.service;

import java.util.List;

import com.pro.esc.inquiry.dao.InquiryVO;

public interface InquiryService {
	void insertInquiry(InquiryVO inquiryVO)throws Exception;
	
	 List<InquiryVO> selectInquiry(InquiryVO inquiryVO) throws Exception;
	 
	 InquiryVO selectOneInquiry(String inquirySeq) throws Exception;
	 
	 void updateCnt(String inquirySeq) throws Exception;
	 
	 int inquiryCount() throws Exception;

	 void updateInquiry(InquiryVO inquiryVO)throws Exception;
	 
	 void deleteInquiry(String inquirySeq)throws Exception;
	
}
