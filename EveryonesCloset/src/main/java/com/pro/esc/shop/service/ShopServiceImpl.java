package com.pro.esc.shop.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.esc.shop.dao.ProductDTO;
import com.pro.esc.shop.dao.ShopDao;

@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopDao shopDao;

	@Override
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
	
	
}
