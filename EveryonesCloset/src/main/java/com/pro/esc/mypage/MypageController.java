package com.pro.esc.mypage;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.esc.inquiry.dao.InquiryDTO;
import com.pro.esc.inquiry.dao.PageDto;
import com.pro.esc.login.dao.UserDTO;
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
	public String myInfo(HttpSession session, ModelMap model) throws Exception {
		
		String userID=(String)session.getAttribute("login");
		UserDTO user=myService.selectUserOne(userID);
		
		String tmp= user.getUserAddr();
		String userAddr=tmp.substring(0,tmp.lastIndexOf(','));
		String userAddrDetail=tmp.substring(tmp.lastIndexOf(',')+1, tmp.length());

		user.setUserAddr(userAddr);
		user.setUserAddrDetail(userAddrDetail);
		model.addAttribute("user",user);
		
		return"mypage/userInfoUpdate.tiles";
	}
	
	@RequestMapping(value="/mypage/inquiry")
	public String myInquiry(@RequestParam(defaultValue="inquiryTitle") String searchOption,
			@RequestParam(defaultValue="") String keyWord,
			@RequestParam(defaultValue="1") int page,HttpSession session,ModelMap model) throws Exception {
		
		String userID=(String)session.getAttribute("login");
		InquiryDTO inquiryDTO=new InquiryDTO();
		inquiryDTO.setUserID(userID);
		
		int count=myService.countMyInquiry(userID);
		PageDto pageDto=new PageDto(count,page);
		//페이징
		inquiryDTO.setStartIndex(pageDto.getStartInx());
		inquiryDTO.setCntPerPage(pageDto.getRowCount());
		//검색
		inquiryDTO.setSearchOption(searchOption);
		inquiryDTO.setKeyWord(keyWord);
		
		List<InquiryDTO> list=myService.selectMyInquiry(inquiryDTO);
		model.addAttribute("list",list);
		model.addAttribute("count", count);
		model.addAttribute("pageDto", pageDto);
		model.addAttribute("keyWord",keyWord);
		model.addAttribute("searchOption",searchOption);

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
		
		HashMap<String,String> map=new HashMap<String, String>();
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
