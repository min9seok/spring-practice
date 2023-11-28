package org.doit.ky.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.doit.ky.domain.NoticeVO;
import org.doit.ky.persistence.NoticeDao;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

// noticeDetail.htm?seq= 요청 > 호출 컨트롤러
public class NoticeDetailController implements Controller{

	private NoticeDao noticeDao;
	public NoticeDetailController() {}
	public NoticeDetailController(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("noticeDetail.jsp");
		String seq = request.getParameter("seq");
		NoticeVO vo = this.noticeDao.getNotice(seq);
		mv.addObject("vo",vo);
		return mv;
	}

}
