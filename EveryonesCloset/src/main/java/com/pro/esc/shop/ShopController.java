package com.pro.esc.shop;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.col.channel.UploadFileUtils;
import com.google.gson.Gson;
import com.pro.esc.shop.dao.ProductDTO;
import com.pro.esc.shop.service.ShopService;

@Controller
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	@RequestMapping(value="/shop")
	public String shop(ModelMap map) throws Exception {
		
		//map.addAttribute("proCateSeq",0);
		
		/*List<ProductDTO> list=shopService.selectProListALL();
		map.addAttribute("list",list);*/
		
		return "shop/shopList.tiles";
	}
	
	@RequestMapping(value="proList",produces="text/json; charset=UTF-8")
	@ResponseBody
	public String shopList(HttpServletRequest req, HttpServletResponse res,
						@RequestParam HashMap<String,String> map)throws Exception {
		
		int proCateSeq=Integer.parseInt(req.getParameter("proCateSeq"));
		
		System.out.println("proCateSeq: "+proCateSeq);
		
		List<ProductDTO> list=shopService.selectProList(map);
		
		Gson gson=new Gson();
		String productList=gson.toJson(list);
		
		System.out.println("productList: "+productList);
		
		return productList;
		
	}
	
	@RequestMapping(value="/addProduct")
	public String addProductPage() {
		
		return "shop/shopAdd.tiles";
	}
	
	@RequestMapping(value="addGoods")
	public String addGoods(HttpServletRequest req, HttpServletResponse res, MultipartFile file) throws Exception {
		
		String proName=req.getParameter("proName");
		String proStock=req.getParameter("proStock");
		String proPrice=req.getParameter("proPrice");
		String proBrand=req.getParameter("proBrand");
		String sizeSeq=req.getParameter("sizeSeq");
		String proCateSeq=req.getParameter("proCateSeq");
		//String proImgPath=req.getParameter("proImgPath");
		
		System.out.println("proName:" + proName);
		System.out.println("sizeSeq: "+ sizeSeq);
		System.out.println("proPrice: "+proPrice);
		
		ProductDTO pro=new ProductDTO();
		pro.setProBrand(proBrand);
		pro.setProName(proName);
		pro.setProPrice(Integer.parseInt(proPrice));
		pro.setProStock(Integer.parseInt(proStock));
		pro.setProCateSeq(Integer.parseInt(proCateSeq));
		pro.setSizeSeq(Integer.parseInt(sizeSeq));
		//pro.setProImgPath(proImgPath);
		
		/*if(file.isEmpty()){
	         System.out.println("업로드 파일이 존재하지 않습니다.");
	         
	      } else {
	         res.setCharacterEncoding("UTF-8");
	         res.setContentType("text/html;charset=utf-8");
	         //String uploadPath=req.getSession().getServletContext().getContextPath();

	         String uploadPath="C:\\workspace_spring\\CoL\\src\\main\\webapp\\resources\\fileUpload\\chnlImg";
			
			 String filePath=UploadFileUtils.uploadFile(uploadPath,userID, file.getOriginalFilename(), file.getBytes());
			 
	         chnlVO.setChannelImg(uploadPath+filePath);
	         
	      }*/
		
		shopService.insertProduct(pro);
		
		return "redirect:/shop";
	}
}
