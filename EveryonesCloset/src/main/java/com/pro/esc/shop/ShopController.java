package com.pro.esc.shop;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.pro.esc.inquiry.dao.PageDto;
import com.pro.esc.shop.dao.ProductDTO;
import com.pro.esc.shop.service.ShopService;

@Controller
public class ShopController {
	
	@Autowired
	private ShopService shopService;
	
	//상품리스트 첫화면
	@RequestMapping(value="/shop")
	public String shop(@RequestParam("proCateSeq")String proCateSeq, 
					   @RequestParam(defaultValue="1") int page, ModelMap model) throws Exception {
		
		HashMap<String,Object> map=new HashMap<String, Object>();
		map.put("proCateSeq", proCateSeq);
		System.out.println("proCateSeq"+proCateSeq);
		
		int count= shopService.productCount(map);
		
		System.out.println("count::"+ count);
		
		PageDto pageDto=new PageDto(count,page);
		System.out.println("pageDto.getStartInx()::"+pageDto.getStartInx());
		map.put("startIndex",pageDto.getStartInx());
		map.put("cntPerPage",pageDto.getRowCount());
		
		List<ProductDTO> list=shopService.selectProList(map);
		
		
		
		if(!list.isEmpty())
		{
			String proImgPath = "";
			
		    for(int i=0;i<list.size();i++)
		      {
		        int pathStartIndex=list.get(i).getProImgPath().indexOf("resources");

		         if(pathStartIndex > -1){
		        	 proImgPath = list.get(i).getProImgPath().substring(pathStartIndex);
		         } else {
		        	 proImgPath = "resources/images/shop/product12.jpg";
		         }
		         
		         list.get(i).setProImgPath(proImgPath);
		      }
		    
		    
		    
		    	if(Integer.parseInt(proCateSeq)==0) {
					model.addAttribute("title","ALL");
					
				}else {
					model.addAttribute("title",list.get(1).getProCateName());
					
				}
		    	model.addAttribute("list",list);
		    	model.addAttribute("count",count);
		    	model.addAttribute("pageDto", pageDto);
		    
			
		}
		return "shop/shopList.tiles";
		
	}
	
	/*//ajax json방식으로 상품리스트 받기
	@RequestMapping(value="proList",produces="text/json; charset=UTF-8")
	@ResponseBody
	public String shopList(HttpServletRequest req, HttpServletResponse res,
						@RequestParam HashMap<String,String> map)throws Exception {
		
		String cateSeq=req.getParameter("proCateSeq");
		
		System.out.println("proCateSeq: "+cateSeq);
		
		if(cateSeq=="" ||cateSeq==null) {
			cateSeq="0";
		}
		int proCateSeq=Integer.parseInt(cateSeq);
		
		List<ProductDTO> list=shopService.selectProList(map);
		String proImgPath = "";
	
	    for(int i=0;i<list.size();i++)
	      {
	        int pathStartIndex=list.get(i).getProImgPath().indexOf("resources");
	         System.out.println("pathStartIndex: "+pathStartIndex);
	         if(pathStartIndex > -1){
	        	 proImgPath = list.get(i).getProImgPath().substring(pathStartIndex);
	         } else {
	        	 proImgPath = "resources/images/shop/product12.jpg";
	         }
	         
	         list.get(i).setProImgPath(proImgPath);
	      }
	      
		Gson gson=new Gson();
		String productList=gson.toJson(list);
		
		System.out.println("productList: "+productList);
		
		return productList;
		
	}
	*/

	
	
	//상품추가 페이지이동. 추후 관리자만 할수 있도록 수정할 예정
	@RequestMapping(value="/addProduct")
	public String addProductPage() {
		
		return "shop/shopAdd.tiles";
	}
	
	//상품추가 로직
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
		
		if(file.isEmpty()){
	         System.out.println("업로드 파일이 존재하지 않습니다.");
	         pro.setProImgPath("nothing");
	         
	      } else {
	         res.setCharacterEncoding("UTF-8");
	         res.setContentType("text/html;charset=utf-8");
	         String uploadPath1=req.getSession().getServletContext().getRealPath("/");
	         String attachPath="resources/fileUpload/productImg";
	         
	         String uploadPath=uploadPath1+attachPath;
	        
			 String filePath=UploadFileUtils.uploadFile(uploadPath,Integer.parseInt(proCateSeq), file.getOriginalFilename(), file.getBytes());
			 pro.setProImgPath(uploadPath+filePath);
	         
	      }
		
		shopService.insertProduct(pro);
		
		return "redirect:/shop";
	}
	
	
	//개별 상품설명페이지
	@RequestMapping(value="productDetail/{proSeq}")
	public String productDetail(@PathVariable("proSeq") int proSeq,HttpServletRequest req,ModelMap map) throws Exception{
		
		ProductDTO pro=new ProductDTO();
		System.out.println("seq::"+ proSeq);
		pro=shopService.selectProOne(proSeq);
		
		String proImgPath = "";
		int pathStartIndex= pro.getProImgPath().indexOf("resources");
		
		if(pathStartIndex > -1)
		{
			proImgPath=pro.getProImgPath().substring(pathStartIndex);
		}else {
			proImgPath="resources/images/shop/product12.jpg";
		}
		pro.setProImgPath(proImgPath);
		
		map.addAttribute("pro",pro);
		
		return "shop/productDetail.tiles";
		
	}
}
