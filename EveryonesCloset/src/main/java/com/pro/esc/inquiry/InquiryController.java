package com.pro.esc.inquiry;

import java.util.HashMap;
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
		String inquiryParent= req.getParameter("inquiryParent");
		String userID= req.getParameter("userID");
		System.out.println("inquiryParent: "+inquiryParent );
		System.out.println("userID: "+userID );
		System.out.println("글쓰기페이지inquirySeq"+inquirySeq);
		
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("inquiryParent",inquiryParent);
		
		InquiryVO info=new InquiryVO();
		
		 if (inquirySeq != null) {
			  info= inquiryService.selectOneInquiry(inquirySeq);
		 }else {
			  info= inquiryService.selectRepInfo(map);
			
		 }
		 modelMap.addAttribute("info", info);
		return "inquiry/inquiryWrite.tiles";
	}
	
	
	@RequestMapping(value="/reply")
	public String inquiryReply(@RequestParam("userID") String userID,
								@RequestParam("inquiryTitle") String inquiryTitle,
								@RequestParam("inquiryContent") String inquiryContent,
								@RequestParam("inquiryParent") int inquiryParent,
								@RequestParam("inquirySeqOrd") int inquirySeqOrd,
								@RequestParam("inquiryIndent") int inquiryIndent,
			HttpServletRequest req, ModelMap modelMap)throws Exception{
		
		InquiryVO inquiryVO=new InquiryVO();
		inquiryVO.setUserID(userID);
		inquiryVO.setInquiryTitle("RE: "+inquiryTitle);
		inquiryVO.setInquiryContent(inquiryContent);
		inquiryVO.setInquiryParent(inquiryParent);
		inquiryVO.setInquiryIndent(inquiryIndent);
		inquiryVO.setInquirySeqOrd(inquirySeqOrd);
		
		inquiryService.insertInqReply(inquiryVO);
		
		return "redirect:/inquiry"; //저장후 글목록으로
	}
	
	
	//RequestParam으로 값을 받아와서 실행해봄
	@RequestMapping(value="inquirySave")
	public String inquirySave(@RequestParam("userID") String userID,
							@RequestParam("inquirySeq") String inquirySeq,
							@RequestParam("inquiryTitle") String inquiryTitle,
							@RequestParam("inquiryContent") String inquiryContent,
							HttpServletRequest req) throws Exception {
	
		String inquiryParent=req.getParameter("inquiryParent");
		String inquirySeqOrd=req.getParameter("inquirySeqOrd");
		String inquiryIndent=req.getParameter("inquiryIndent");
		System.out.println("저장inquirySeq"+inquirySeq);
		System.out.println("값넘어오나... inquiryParent: " + inquiryParent);
		System.out.println("값넘어오나... inquirySeqOrd: " + inquirySeqOrd);
		InquiryVO inquiryVO=new InquiryVO();
		inquiryVO.setInquiryTitle(inquiryTitle);
		inquiryVO.setInquiryContent(inquiryContent);
		inquiryVO.setUserID(userID);

		
		if(inquirySeq==""||"".equals(inquirySeq)||"0".equals(inquirySeq))
		{
			if(inquiryParent==""||"".equals(inquiryParent)||"0".equals(inquiryParent))
			{
				inquiryService.insertInquiry(inquiryVO);
				
			}
			else {
				inquiryVO.setInquiryTitle("RE: "+inquiryTitle);
				inquiryVO.setInquiryParent(Integer.parseInt(inquiryParent));
				inquiryVO.setInquirySeqOrd(Integer.parseInt(inquirySeqOrd));
				inquiryVO.setInquiryIndent(Integer.parseInt(inquiryIndent));
				inquiryService.insertInqReply(inquiryVO);
			}
			
		}else {
			inquiryVO.setInquirySeq(Integer.parseInt(inquirySeq));
			inquiryService.updateInquiry(inquiryVO);
		}
			
		return "redirect:/inquiry";
	}
	
	@RequestMapping(value="read")
	public String inquiryRead(HttpServletRequest req, ModelMap modelMap) throws Exception{
		
		
		String inquirySeq=req.getParameter("inquirySeq");
		String inquiryParent=req.getParameter("inquiryParent");
		String inquirySeqOrd=req.getParameter("inquirySeqOrd");
		String inquiryIndent=req.getParameter("inquiryIndent");
		
		inquiryService.updateCnt(inquirySeq); //조회수 증가
		System.out.println("inquirySeq "+ inquirySeq);
		System.out.println("inquiryParent "+inquiryParent);
		System.out.println("inquirySeqOrd "+ inquirySeqOrd);
		System.out.println("inquiryIndent "+inquiryIndent);
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
