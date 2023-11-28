package org.doit.ky.controller;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.doit.ky.domain.NoticeVO;
import org.doit.ky.persistence.NoticeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/customer/*")
public class CustomerController {

	@Autowired
	private NoticeDao dao;

	@GetMapping("noticeDel.htm")
	public String noticeDel(@RequestParam("seq") String seq) throws ClassNotFoundException, SQLException {

		int count = this.dao.delete(seq);
		if(count == 1) {
			return "redirect:notice.htm";	
		}else {
			return "redirect:noticeDetail.htm?seq="+seq+"&error";
		}		
	} 

	@PostMapping("noticeEdit.htm")
	public String noticeEdit(NoticeVO vo) throws ClassNotFoundException, SQLException {

		int count = this.dao.update(vo);
		if(count == 1) {
			return "redirect:noticeDetail.htm?seq="+vo.getSeq();	
		}else {
			return "redirect:notice.htm";
		}		
	}

	@GetMapping("noticeEdit.htm")
	public String noticeEdit(@RequestParam("seq") String seq, Model model  ) throws ClassNotFoundException, SQLException {

		NoticeVO vo = this.dao.getNotice(seq);
		model.addAttribute("vo",vo);
		return "noticeEdit.jsp";
	}

	@PostMapping("noticeReg.htm")
	public String noticeReg(NoticeVO vo) throws ClassNotFoundException, SQLException {
		vo.setWriter("kmys");

		int count = this.dao.insert(vo);
		if(count == 1) {
			return "redirect:notice.htm";	
		}else {
			return "noticeReg.jsp?error";
		}

	}

	@GetMapping("noticeReg.htm")
	public String noticeReg() throws ClassNotFoundException, SQLException {

		return "noticeReg.jsp";		
	}

	@GetMapping("noticeDetail.htm")
	public String noticeDetail(@RequestParam("seq") String seq, Model model  ) throws ClassNotFoundException, SQLException {

		NoticeVO vo = this.dao.getNotice(seq);
		model.addAttribute("vo",vo);
		return "noticeDetail.jsp";
	}
	@GetMapping("notice.htm")
	public String notice(@RequestParam(value = "page", defaultValue = "1") int page
			, @RequestParam(value = "field", defaultValue = "title" ) String field
			, @RequestParam(value = "query" ,defaultValue = "") String query, Model model ) throws ClassNotFoundException, SQLException {
		List<NoticeVO> list = this.dao.getNotices(page, field, query);
		model.addAttribute("list",list);				
		return "notice.jsp";
	}
	//	@GetMapping("notice.htm")
	//	public ModelAndView notice(Locale locale, Model model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
	//		ModelAndView mv = new ModelAndView("notice.jsp");
	//		
	//		String ppage = request.getParameter("page");
	//		String pfield = request.getParameter("field");
	//		String pquery = request.getParameter("query");
	//		
	//		int page = 1;
	//		String field = "title";
	//		String query = "";
	//		
	//		if(ppage != null && !ppage.equals("")) { page = Integer.parseInt(ppage);}
	//		if(pfield != null && !pfield.equals("")) { field = pfield ;}
	//		if(pquery != null && !pquery.equals("")) { query = pquery ;}
	//		
	//		List<NoticeVO> list = this.dao.getNotices(page, field, query);
	//		mv.addObject("list",list);			
	//		return mv;
	//	}


}
