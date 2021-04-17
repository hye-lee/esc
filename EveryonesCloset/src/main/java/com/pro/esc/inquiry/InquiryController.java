package com.pro.esc.inquiry;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pro.esc.inquiry.dao.InquiryVO;
import com.pro.esc.inquiry.dao.PageDto;
import com.pro.esc.inquiry.service.InquiryService;

@Controller
public class InquiryController {
	
	@Autowired
	private InquiryService inquiryService;
	
	//페이징+글목록
	@RequestMapping(value="/inquiry")
	public String inquiry(@ModelAttribute("inquiryVO") InquiryVO inquiryVO,
			@RequestParam(defaultValue="1") int page, Model model,HttpSession session) throws Exception {
		
		List<InquiryVO> listView=inquiryService.selectInquiry(inquiryVO);
		
		model.addAttribute("listView",listView);
		String checkSession=(String) session.getAttribute("login");
		
		int count=inquiryService.inquiryCount();
		PageDto pageDto=new PageDto(count,page);
		inquiryVO.setStartIndex(pageDto.getStartInx());
		inquiryVO.setCntPerPage(pageDto.getRowCount());
		
		List<InquiryVO> list=inquiryService.selectInquiry(inquiryVO);
		model.addAttribute("list",list);
		model.addAttribute("count", count);
		model.addAttribute("pageDto", pageDto);
		model.addAttribute("checkSession",checkSession);
		
		return "inquiry/inquiryList.tiles";
	}
	
	@RequestMapping(value="/inquiryWrite")
	public String inquiryWrite(HttpServletRequest req, ModelMap modelMap) throws Exception {
		
		String inquirySeq = req.getParameter("inquirySeq");
		System.out.println("글쓰기페이지inquirySeq"+inquirySeq);
		 if (inquirySeq != null) {
			 InquiryVO info= inquiryService.selectOneInquiry(inquirySeq);
			 modelMap.addAttribute("info", info);
		 }
			
		return "inquiry/inquiryWrite.tiles";
	}
	
	//RequestParam으로 값을 받아와서 실행해봄
	@RequestMapping(value="inquirySave")
	public String inquirySave(@RequestParam("userID") String userID,
							@RequestParam("inquirySeq") String inquirySeq,
							@RequestParam("inquiryTitle") String inquiryTitle,
							@RequestParam("inquiryContent") String inquiryContent,
							HttpServletRequest req) throws Exception {
	
	
		System.out.println("저장inquirySeq"+inquirySeq);
		InquiryVO inquiryVO=new InquiryVO();
		inquiryVO.setInquiryTitle(inquiryTitle);
		inquiryVO.setInquiryContent(inquiryContent);
		inquiryVO.setUserID(userID);
		
		
		if(inquirySeq==null||"".equals(inquirySeq))
		{
			inquiryService.insertInquiry(inquiryVO);
		
		}else {
			inquiryVO.setInquirySeq(inquirySeq);
			inquiryService.updateInquiry(inquiryVO);
		}
			
		return "redirect:/inquiry";
	}
	
	@RequestMapping(value="read")
	public String inquiryRead(HttpServletRequest req, ModelMap modelMap) throws Exception{
		
		
		String inquirySeq=req.getParameter("inquirySeq");
		inquiryService.updateCnt(inquirySeq); //조회수 증가
		System.out.println("inquirySeq"+ inquirySeq);
		
		InquiryVO info=inquiryService.selectOneInquiry(inquirySeq); //글 select
		
		modelMap.addAttribute("info",info);
		
		return"inquiry/inquiryView.tiles";
		
	}
	
	
	@RequestMapping(value="delete")
	public String delete(HttpServletRequest req)throws Exception{
		
		String inquirySeq=req.getParameter("inquirySeq");
		
		inquiryService.deleteInquiry(inquirySeq);
		
		return "redirect:/inquiry";
	}

}
