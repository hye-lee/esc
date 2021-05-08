package com.pro.esc.shop.service;

import java.util.HashMap;
import java.util.List;

import com.pro.esc.shop.dao.ProductDTO;

public interface ShopService {
	
	void insertProduct(ProductDTO productDTO) throws Exception;
	
	List<ProductDTO> selectProList(HashMap<String, Object> map) throws Exception;
	
	List<ProductDTO> selectProListALL()throws Exception;
	
	ProductDTO selectProOne(int proSeq) throws Exception;
	
	void updateStock(int proSeq)throws Exception;
	
	List<ProductDTO> selectTOP5()throws Exception;
	
	int productCount(HashMap<String,Object> map) throws Exception;
}
