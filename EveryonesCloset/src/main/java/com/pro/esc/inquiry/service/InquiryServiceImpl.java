package com.pro.esc.inquiry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.esc.inquiry.dao.InquiryDao;
import com.pro.esc.inquiry.dao.InquiryVO;

@Service
public class InquiryServiceImpl implements InquiryService{

	@Autowired
	private InquiryDao inquiryDao;
	
	@Override
	public void insertInquiry(InquiryVO inquiryVO) throws Exception {
		// TODO Auto-generated method stub
		inquiryDao.insertInquiry(inquiryVO);
	}
		
}
