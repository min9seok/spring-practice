package org.doit.ky;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.doit.ky.domain.DeptDTO;
import org.doit.ky.domain.EmpDTO;
import org.doit.ky.mapper.MemberMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.Setter;

@Controller
public class HomeController {
	
	@Setter(onMethod=@__({@Autowired}))
	private MemberMapper mapper;
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
//	p356 컨트롤러메서드의 파라미터, 리턴자료형
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		ModelAndView mv = new ModelAndView("home");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return mv;
	}
	@RequestMapping(value = "/deptEmp", method = RequestMethod.GET)
	public ModelAndView selectDept(@RequestParam(value = "detpno", defaultValue = "10")int deptno, Model model) throws Exception {		
		
		ModelAndView mv = new ModelAndView("deptemp");					
		
		List<DeptDTO> listdept = null;
		listdept = this.mapper.selectDept();
		
		List<EmpDTO> listemp = null;
		listemp = this.mapper.selectEmp(deptno);
		
		model.addAttribute("listdept",listdept);
		model.addAttribute("listemp",listemp);
		
		return mv;
	}
	
}
