package com.pro.esc.shop.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pro.esc.shop.dao.ProductDTO;
import com.pro.esc.shop.dao.ShopDao;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopDao shopDao;

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void insertProduct(ProductDTO productDTO) throws Exception {
		// TODO Auto-generated method stub
		shopDao.insertProduct(productDTO);
		
	}

	@Override
	public List<ProductDTO> selectProList(HashMap<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return shopDao.selectProList(map);
	}

	@Override
	public List<ProductDTO> selectProListALL() throws Exception {
		// TODO Auto-generated method stub
		return shopDao.selectProListALL();
	}

	@Override
	public ProductDTO selectProOne(int proSeq) throws Exception {
		// TODO Auto-generated method stub
		return shopDao.selectProOne(proSeq);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
	public void updateStock(int proSeq) throws Exception {
		// TODO Auto-generated method stub
		shopDao.updateStock(proSeq);
	}

	@Override
	public List<ProductDTO> selectTOP5() throws Exception {
		// TODO Auto-generated method stub
		return shopDao.selectTOP5();
	}
	
	
}
