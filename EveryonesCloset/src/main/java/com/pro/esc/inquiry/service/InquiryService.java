package com.pro.esc.inquiry.service;

import java.util.HashMap;
import java.util.List;

import com.pro.esc.inquiry.dao.InquiryDTO;

public interface InquiryService {
	void insertInquiry(InquiryDTO inquiryDTO)throws Exception;
	
	 List<InquiryDTO> selectInquiry(InquiryDTO inquiryDTO) throws Exception;
	 
	 InquiryDTO selectOneInquiry(String inquirySeq) throws Exception;
	 
	 void updateCnt(String inquirySeq) throws Exception;
	 
	 int inquiryCount(InquiryDTO inquiryDTO) throws Exception;

	 void updateInquiry(InquiryDTO inquiryDTO)throws Exception;
	 
	 void deleteInquiry(String inquirySeq)throws Exception;
	 
	 void insertInqReply(InquiryDTO inquiryDTO) throws Exception;
	 
	 InquiryDTO selectRepInfo(HashMap<String,String> map) throws Exception;
	 
	 void updateInqReSeq(InquiryDTO inquiryDTO) throws Exception;
	
}
