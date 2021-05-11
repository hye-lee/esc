package com.pro.esc.admin;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.esc.admin.service.AdminService;
import com.pro.esc.inquiry.dao.InquiryDTO;
import com.pro.esc.inquiry.dao.PageDto;
import com.pro.esc.login.dao.UserDTO;
import com.pro.esc.order.dao.OrderDTO;
import com.pro.esc.shop.dao.ProductDTO;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="admin")
	public String adminPage() {
		return "admin/admin.tiles";
	}
	
	@RequestMapping(value="/admin/user")
	public String adminUser(HttpSession session, ModelMap model) throws Exception {
		System.out.println("user페이지");
		
		String userID=(String)session.getAttribute("login");
		List<UserDTO> list= adminService.selectAllUser(userID);
		
		model.addAttribute("list",list);
		
		return"admin/adminUser.blocks";
	}
	
	@RequestMapping(value="/admin/deleteUser")
	@ResponseBody
	public int deleteUser(@RequestParam("userID")String userID, ModelMap model)throws Exception{
		
		int result=0;
		
		if(adminService.updateUserStat(userID)==1)
		{
			result=1;
		}

		return result;
	}
	
	@RequestMapping(value="/admin/product")
	public String adminProduct(ModelMap model) throws Exception {
		System.out.println("product페이지");
		
		List<ProductDTO> list=adminService.selectAllProduct();	
	
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
	         int proCateSeq=list.get(i).getProCateSeq();
	         String proCateName="";
	         switch(proCateSeq) {
	         	case 1:proCateName="Outer"; break;
	         	case 2:proCateName="Top"; break;
	         	case 3:proCateName="Dress"; break;
	         	case 4:proCateName="Pants"; break;
	         	case 5:proCateName="Skirt"; break;
	         	case 6:proCateName="Shoes"; break;
	         	case 7:proCateName="Bags"; break;
	         }
	         
	         int sizeSeq=list.get(i).getSizeSeq();
	         String sizeName="";
	         switch(sizeSeq) {
	         	case 1:sizeName="XS"; break;
	         	case 2:sizeName="S"; break;
	         	case 3:sizeName="M"; break;
	         	case 4:sizeName="L"; break;
	         	case 5:sizeName="XL"; break;
	         	case 6:sizeName="XXL"; break;   	
	         }
 
	         list.get(i).setSizeName(sizeName);
	         list.get(i).setProCateName(proCateName);
	         list.get(i).setProImgPath(proImgPath);
	      }
		
		model.addAttribute("list",list);
		
		return"admin/adminPro.blocks";
	}
	
	@RequestMapping(value="/admin/order")
	public String adminOrder(ModelMap model) throws Exception {
		System.out.println("order페이지");
		
		List<OrderDTO> list=adminService.selectAllOrder();
		
		model.addAttribute("list",list);
		
		return"admin/adminOrd.blocks";
	}
	
	@RequestMapping(value="/admin/inquiry")
	public String adminInquiry(@RequestParam(defaultValue="1") int page, ModelMap model) throws Exception {
		System.out.println("inquiry페이지");
		
		int count=adminService.countInquiry();
		PageDto pageDto=new PageDto(count,page);
		//페이징
		HashMap<String,Object> map=new HashMap<String,Object> ();
		map.put("startIndex",pageDto.getStartInx());
		map.put("cntPerPage",pageDto.getRowCount());
		
		
		List<InquiryDTO> list=adminService.selectAllInquiry(map);
		model.addAttribute("list",list);
		model.addAttribute("count", count);
		model.addAttribute("pageDto", pageDto);

		return"admin/adminInq.blocks";
	}

}
