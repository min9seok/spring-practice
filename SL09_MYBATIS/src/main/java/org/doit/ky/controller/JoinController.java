package org.doit.ky.controller;

import org.doit.ky.domain.MemberVO;
import org.doit.ky.persistence.MemberDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/joinus/*")
public class JoinController {
	
	@Autowired
	private MemberDao dao;
	
	@GetMapping("/login.htm")
	public String login() throws Exception{
		return "joinus.login";
	}
	
	@GetMapping("/join.htm")
	public String join() throws Exception{
		return "joinus.join";
	}
	
	@PostMapping("/join.htm")
	public String join(MemberVO vo) throws Exception{
		this.dao.insert(vo);
		return "redirect:../index.htm";
	}
}
