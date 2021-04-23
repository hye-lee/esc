package com.pro.esc.shop.service;

import java.util.HashMap;
import java.util.List;

import com.pro.esc.shop.dao.ProductDTO;

public interface ShopService {
	
	void insertProduct(ProductDTO productDTO) throws Exception;
	
	List<ProductDTO> selectProList(HashMap<String, String> map) throws Exception;
	
	List<ProductDTO> selectProListALL()throws Exception;
}
