package com.pro.esc.mypage;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pro.esc.inquiry.dao.InquiryDTO;
import com.pro.esc.inquiry.dao.PageDto;
import com.pro.esc.login.dao.UserDTO;
import com.pro.esc.mypage.dao.MyOrderDTO;
import com.pro.esc.mypage.service.MypageService;
import com.pro.esc.order.dao.OrderDTO;
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
	public String myOrder(@RequestParam(defaultValue="1") int page, HttpSession session,ModelMap model) throws Exception {
		
		String userID=(String)session.getAttribute("login");
		
		int count=myService.countMyOrder(userID);
		PageDto pageDto=new PageDto(count,page);
		OrderDTO order=new OrderDTO();
		
		order.setUserID(userID);
		order.setStartIndex(pageDto.getStartInx());
		order.setCntPerPage(pageDto.getRowCount());
		
		List<OrderDTO> list=myService.selectMyOrder(order);
		model.addAttribute("list",list);
		model.addAttribute("count", count);
		model.addAttribute("pageDto", pageDto);
		
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
	
	@RequestMapping(value="mypage/orderDetail/{ordSeq}")
	public String orderDetail(@PathVariable("ordSeq") String ordSeq, HttpSession session, ModelMap model)throws Exception{
		
		String userID=(String)session.getAttribute("login");
		
		UserDTO userDTO=myService.selectUserOne(userID);
		userDTO.setUserID(userID);
		
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("userID", userID);
		map.put("ordSeq", ordSeq);
		
		List<MyOrderDTO> list=myService.selectOrderDetail(map);
		
		String proImgPath = "";
		
		if(list!=null) {
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
		}
		
		OrderDTO order=myService.selectOrderDetailRec(ordSeq);

		model.addAttribute("list",list);
		model.addAttribute("user",userDTO);
		model.addAttribute("order",order);
		return "mypage/orderDetail.tiles";
	}
	
	@RequestMapping(value="mapage/userInfoUpdata")
	public String updataUserInfo(HttpServletRequest req,ModelMap model)throws Exception{
		
		UserDTO user=new UserDTO();
		
		user.setUserName((String)req.getAttribute("userName"));
		user.setUserAddr((String)req.getAttribute("userAddr"));
		user.setUserPostCode((String)req.getAttribute("userPostCode"));
		user.setUserEmail((String)req.getAttribute("userEmail"));
		user.setUserID((String)req.getAttribute("userID"));
		user.setUserPostCode((String)req.getAttribute("userPostCode"));
		//user.setUserPw((String)req.getAttribute("userPw"));
		int count=myService.updataUserInfo(user);
		
		model.addAttribute("count",count);
		
		return "mypage/userInfoUpdate.tiles";
	}
	
	@RequestMapping(value="mypage/updateUserPw")
	public String updateUserPw(HttpServletRequest req) throws Exception{
		user.setUserPw((String)req.getAttribute("userPw"));
		return "mypage/userUpdateUserPw.tiles";
	}
}
