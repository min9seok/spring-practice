package org.doit.ky;

import java.util.Locale;

import org.doit.ky.mapper.TimeMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MybatisController {
	
	private static final Logger logger = LoggerFactory.getLogger(MybatisController.class);
	
	@Autowired
	private TimeMapper timeMapper;
	
	@RequestMapping(value = "/time", method = RequestMethod.GET)
	public String getTime(Locale locale, Model model) {
		logger.info("MybatisController.getTime Controller Method");
		
		String nowTime = this.timeMapper.getTime();
		String NextTime = this.timeMapper.getNextTime();
		model.addAttribute("nowTime", nowTime );
		model.addAttribute("NextTime", NextTime );
		model.addAttribute("name", "admin" );
		
		return "time";
	}
	
}
