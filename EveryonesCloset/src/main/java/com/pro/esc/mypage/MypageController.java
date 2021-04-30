package com.pro.esc.mypage;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.esc.mypage.service.MypageService;
import com.pro.esc.register.service.SHA256;

@Controller
public class MypageController {
	
	@Autowired
	private MypageService myService;
	
	@RequestMapping(value="/mypage")
	public String mypage() {
		return"mypage/mypage.tiles";
	}
	
	@RequestMapping(value="/mypage/myInfo")
	public String myInfo() {
		return"mypage/userInfoUpdate.tiles";
	}
	
	@RequestMapping(value="/mypage/inquiry")
	public String myInquiry() {
		return"mypage/myInquiry.tiles";
	}
	
	@RequestMapping(value="/mypage/order")
	public String myOrder() {
		return"mypage/myOrder.tiles";
	}
	
	@RequestMapping(value="/mypage/withdrawal")
	public String deleteUser() {
		return"mypage/userDelete.tiles";
	}
	
	@RequestMapping(value="/mypage/checkPw")
	@ResponseBody
	public String checkPw(@RequestParam("userPw")String userPw,HttpSession session) throws Exception {
		
		HashMap<String,String> map=new HashMap<>();
		SHA256 sha256=new SHA256();
		String enUserPw=sha256.encrypt(userPw);
		map.put("userPw", enUserPw);
		map.put("userID", (String)session.getAttribute("login") );
		
		String result=myService.checkUserPw(map);
		System.out.println("결과::" +result);
		return result;
	}
	
	@RequestMapping(value="/mypage/deleteUser")
	public String delUser( HttpSession session) throws Exception{
		
		String userID=(String)session.getAttribute("login");
		
		if(myService.updateUserStat(userID)==1)
		{
			session.invalidate();
			return "mypage/bye.tiles";
		}
		else {
			return "redirect:/mypage/withdrawal";
		}
		
	}
}
