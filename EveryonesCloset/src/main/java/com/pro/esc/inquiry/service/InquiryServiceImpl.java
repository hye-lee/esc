package com.pro.esc.inquiry.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.esc.inquiry.dao.InquiryDTO;
import com.pro.esc.inquiry.dao.InquiryDao;

@Service
public class InquiryServiceImpl implements InquiryService{

	@Autowired
	private InquiryDao inquiryDao;
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void insertInquiry(InquiryDTO inquiryDTO) throws Exception {
		// TODO Auto-generated method stub
		inquiryDao.insertInquiry(inquiryDTO);
	}

	@Override
	public List<InquiryDTO> selectInquiry(InquiryDTO inquiryDTO) throws Exception {
		// TODO Auto-generated method stub
		
		return inquiryDao.selectInquiry(inquiryDTO);
	}

	
	public InquiryDTO selectOneInquiry(String inquirySeq) throws Exception {
		// TODO Auto-generated method stub
		return inquiryDao.selectOneInquiry(inquirySeq);
	}

	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void updateCnt(String inquirySeq) throws Exception {
		// TODO Auto-generated method stub
		inquiryDao.updateCnt(inquirySeq);
		
	}
	
	public int inquiryCount() throws Exception{
		
		return inquiryDao.inquiryCount();
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void updateInquiry(InquiryDTO inquiryDTO) throws Exception {
		// TODO Auto-generated method stub
		
		 inquiryDao.updateInquiry(inquiryDTO);
		 
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void deleteInquiry(String inquirySeq) throws Exception {
		// TODO Auto-generated method stub
		 inquiryDao.deleteInquiry(inquirySeq);
	}

	@Override
	public void insertInqReply(InquiryDTO inquiryDTO) throws Exception {
		// TODO Auto-generated method stub
		
		inquiryDao.insertInqReply(inquiryDTO);
	}

	@Override
	public InquiryDTO selectRepInfo(HashMap<String,String> map) throws Exception {
		// TODO Auto-generated method stub
		return inquiryDao.selectRepInfo(map);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void updateInqReSeq(InquiryDTO inquiryDTO) throws Exception {
		// TODO Auto-generated method stub
		inquiryDao.updateInqReSeq(inquiryDTO);
	}



	
}
