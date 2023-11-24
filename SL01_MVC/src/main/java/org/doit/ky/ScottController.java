package org.doit.ky;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.doit.ky.domain.DeptDTO;
import org.doit.ky.domain.EmpDTO;
import org.doit.ky.mapper.scott.DeptMapper;
import org.doit.ky.mapper.scott.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@Controller
@Log4j
@RequestMapping("/scott/*")
public class ScottController {
	
//	@Autowired
	@Setter(onMethod =@__({@Autowired}))	
	private DeptMapper deptMapper;
	@Autowired
	private EmpMapper empMapper;
//	@RequestMapping(value = "/dept")
//	public void dept(Locale locale, Model model) {
//		log.info("> /scott/dept");
//		List<DeptDTO> list = this.deptMapper.selectDept();
//		model.addAttribute("list",list);
//	}
	@GetMapping(value = "/dept")
	public void dept(Locale locale, Model model) {
		log.info("> /scott/dept");
		List<DeptDTO> list = this.deptMapper.selectDept();
		model.addAttribute("list",list);
	}
	@PostMapping("/dept")
	public void dept(Model model) {
		dept(null,model);
	}
	
	@PostMapping("/emp")
	public String emp(@RequestParam(value = "deptno") ArrayList<Integer> deptnos, Model model) {
		log.info("> /scott/emp");
		List<EmpDTO> list = this.empMapper.selectEmp(deptnos);
		model.addAttribute("list",list);
		return "/scott/emp";		
	}
	
}
