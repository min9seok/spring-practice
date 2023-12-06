package org.doit.ky;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;


@Controller
@Log4j
@RequestMapping("/")
public class HomeController {
	
	public HomeController() {
		super();
	}
	@RequestMapping("index.htm")
	public String home() throws Exception {
		return "home.index";
	}
}
