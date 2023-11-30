package org.doit.ky;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/city/*")
public class CityController {
	
	@GetMapping("london")
	public String london() {
		log.info("City london");
		return "city/london.tiles";
	}
	@GetMapping("paris")
	public String paris() {
		log.info("City paris");
		return "city/paris.tiles";
	}
	@GetMapping("seoul")
	public String seoul() {
		log.info("City seoul");
		return "city/seoul.tiles";
	}
}

