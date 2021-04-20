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
	
	@RequestMapping(value="/write")
	public String inquiryWrite(HttpServletRequest req, ModelMap modelMap) throws Exception {
		
		String inquirySeq = req.getParameter("inquirySeq");
		String inquiryParent= req.getParameter("inquiryParent");
		String userID= req.getParameter("userID");
		System.out.println("inquiryParent: "+inquiryParent );
		System.out.println("userID: "+userID );
		System.out.println("글쓰기페이지inquirySeq"+inquirySeq);
		
		return "inquiry/inquiryWrite.tiles";
	}
	
	@RequestMapping(value="/modify")
	public String inquiryModify(HttpServletRequest req, ModelMap modelMap, Model model) throws Exception {
		
		String inquirySeq=req.getParameter("inquirySeq");
		
		InquiryVO info=new InquiryVO();
		info= inquiryService.selectOneInquiry(inquirySeq);
		modelMap.addAttribute("info", info);
		model.addAttribute("plag","modify");
		
		return "inquiry/inquiryWrite.tiles";
	}
	
	
	@RequestMapping(value="/reply")
	public String inquiryReply(HttpServletRequest req, ModelMap modelMap, Model model)throws Exception{
		
		String inquirySeq = req.getParameter("inquirySeq");
		String inquiryParent= req.getParameter("inquiryParent");
		HashMap<String,String> map=new HashMap<String,String>();
		map.put("inquiryParent",inquiryParent);
		map.put("inquirySeq",inquirySeq);
		InquiryVO info=new InquiryVO();
		info= inquiryService.selectRepInfo(map);
		model.addAttribute("plag","reply");
		modelMap.addAttribute("info",info);
		
		return "inquiry/inquiryWrite.tiles"; //저장후 글목록으로
	}
	
	@RequestMapping(value="replySave")
	public String ReplySave(HttpServletRequest req) throws Exception{
		
		String inquiryParent=req.getParameter("inquiryParent");
		String inquirySeqOrd=req.getParameter("inquirySeqOrd");
		String inquiryIndent=req.getParameter("inquiryIndent");

		InquiryVO vo=new InquiryVO();
		
		vo.setInquiryParent(Integer.parseInt(inquiryParent));
		vo.setInquirySeqOrd(Integer.parseInt(inquirySeqOrd));
		inquiryService.updateInqReSeq(vo);
		
		vo.setInquiryTitle(req.getParameter("inquiryTitle"));
		vo.setInquiryContent(req.getParameter("inquiryContent"));
		vo.setUserID(req.getParameter("userID"));
		
		vo.setInquiryIndent(Integer.parseInt(inquiryIndent));
		
		inquiryService.insertInqReply(vo);
		
		
		return "redirect:/inquiry";
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

		InquiryVO inquiryVO=new InquiryVO();
		inquiryVO.setInquiryTitle(inquiryTitle);
		inquiryVO.setInquiryContent(inquiryContent);
		inquiryVO.setUserID(userID);

		
		if(inquirySeq==""||"".equals(inquirySeq)||"0".equals(inquirySeq))
		{
				inquiryService.insertInquiry(inquiryVO);
			
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
