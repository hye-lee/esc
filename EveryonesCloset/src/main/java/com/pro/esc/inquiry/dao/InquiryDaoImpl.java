package com.pro.esc.inquiry.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class InquiryDaoImpl implements InquiryDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void insertInquiry(InquiryDTO inquiryDTO) throws Exception {
		// TODO Auto-generated method stub
		
		InquiryDao mapper= sqlSession.getMapper(InquiryDao.class);
		mapper.insertInquiry(inquiryDTO);
		
	}

	@Override
	public List<InquiryDTO> selectInquiry(InquiryDTO inquiryDTO) throws Exception {
		// TODO Auto-generated method stub
		InquiryDao mapper= sqlSession.getMapper(InquiryDao.class);
		
		return mapper.selectInquiry(inquiryDTO);
	}

	@Override
	public InquiryDTO selectOneInquiry(String inquirySeq) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.getMapper(InquiryDao.class).selectOneInquiry(inquirySeq);
	}

	@Override
	public void updateCnt(String inquirySeq) throws Exception {
		
		sqlSession.getMapper(InquiryDao.class).updateCnt(inquirySeq);
		
	}

	@Override
	public int inquiryCount(InquiryDTO inquiryDTO) throws Exception {
		
		InquiryDao mapper= sqlSession.getMapper(InquiryDao.class);
		return mapper.inquiryCount(inquiryDTO);
	}

	@Override
	public void updateInquiry(InquiryDTO inquiryDTO) throws Exception {
		// TODO Auto-generated method stub
		InquiryDao mapper=sqlSession.getMapper(InquiryDao.class);
		mapper.updateInquiry(inquiryDTO);
	}

	@Override
	public void deleteInquiry(String inquirySeq) throws Exception {
		// TODO Auto-generated method stub
		InquiryDao mapper=sqlSession.getMapper(InquiryDao.class);
		mapper.deleteInquiry(inquirySeq);
	}

	@Override
	public void insertInqReply(InquiryDTO inquiryDTO) throws Exception {
		// TODO Auto-generated method stub
		InquiryDao mapper=sqlSession.getMapper(InquiryDao.class);
		mapper.insertInqReply(inquiryDTO);
	}

	@Override
	public InquiryDTO selectRepInfo(HashMap<String,String> map) throws Exception {
		// TODO Auto-generated method stub
		
		return sqlSession.getMapper(InquiryDao.class).selectRepInfo(map);
	}

	@Override
	public void updateInqReSeq(InquiryDTO inquiryDTO) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.getMapper(InquiryDao.class).updateInqReSeq(inquiryDTO);
	}
	
	
	
	

}
