package org.doit.ky.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.doit.ky.domain.NoticeVO;
import org.doit.ky.persistence.NoticeDao;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// notice.htm 요청 > 호출 컨트롤러
// /customer/notice.htm?page=2&field=title&query=하하하
public class NoticeController implements Controller{

	private NoticeDao noticeDao;
	public NoticeController() {}
	public NoticeController(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
	
		String ppage = request.getParameter("page");
		String pfield = request.getParameter("field");
		String pquery = request.getParameter("query");
		
		int page = 1;
		String field = "title";
		String query = "";
		
		if(ppage != null && !ppage.equals("")) { page = Integer.parseInt(ppage);}
		if(pfield != null && !pfield.equals("")) { field = pfield ;}
		if(pquery != null && !pquery.equals("")) { query = pquery ;}
		
		List<NoticeVO> list = this.noticeDao.getNotices(page, field, query);
		mv.addObject("list",list);			
		mv.setViewName("notice.jsp");
		return mv;
	}

}
