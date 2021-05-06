package com.pro.esc.admin;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.esc.admin.service.AdminService;
import com.pro.esc.login.dao.UserDTO;

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
	public String adminProduct() {
		System.out.println("product페이지");
		return"admin/adminPro.blocks";
	}
	
	@RequestMapping(value="/admin/order")
	public String adminOrder() {
		System.out.println("order페이지");
		return"admin/adminOrd.blocks";
	}
	
	@RequestMapping(value="/admin/inquiry")
	public String adminInquiry() {
		System.out.println("inquiry페이지");
		return"admin/adminInq.blocks";
	}

}
