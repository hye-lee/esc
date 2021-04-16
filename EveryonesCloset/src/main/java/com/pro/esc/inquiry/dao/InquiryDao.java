package com.pro.esc.inquiry.dao;

import java.util.List;

public interface InquiryDao {
	void insertInquiry(InquiryVO inquiryVO) throws Exception;
	
	List<InquiryVO> selectInquiry(InquiryVO inquiryVO) throws Exception;
	
	InquiryVO selectOneInquiry(String inquirySeq) throws Exception;
	
	void updateCnt(String inquirySeq) throws Exception;
	
	int inquiryCount() throws Exception;
}
