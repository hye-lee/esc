package com.pro.esc.inquiry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.esc.inquiry.dao.InquiryDao;
import com.pro.esc.inquiry.dao.InquiryVO;

@Service
public class InquiryServiceImpl implements InquiryService{

	@Autowired
	private InquiryDao inquiryDao;
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void insertInquiry(InquiryVO inquiryVO) throws Exception {
		// TODO Auto-generated method stub
		inquiryDao.insertInquiry(inquiryVO);
	}

	@Override
	public List<InquiryVO> selectInquiry(InquiryVO inquiryVO) throws Exception {
		// TODO Auto-generated method stub
		
		return inquiryDao.selectInquiry(inquiryVO);
	}

	
	public InquiryVO selectOneInquiry(String inquirySeq) throws Exception {
		// TODO Auto-generated method stub
		return inquiryDao.selectOneInquiry(inquirySeq);
	}

	
	public void updateCnt(String inquirySeq) throws Exception {
		// TODO Auto-generated method stub
		inquiryDao.updateCnt(inquirySeq);
		
	}
	
	public int inquiryCount() throws Exception{
		
		return inquiryDao.inquiryCount();
	}



	
}
