package org.doit.ik;

import org.doit.ik.mapper.DeptEmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class DeptEmpController {

	@Setter(onMethod=@__({@Autowired}))
	private DeptEmpMapper deptEmpMapper;
	
	@GetMapping("/deptEmp")
	public String depEmp(  
			@RequestParam( value =  "deptno" , defaultValue = "10") int deptno
			,   Model model) {
		// 1)
		model.addAttribute("deptList", this.deptEmpMapper.selectDept());
		// 2)
		model.addAttribute("empList", this.deptEmpMapper.selectEmp(deptno));
		
		return "deptEmpTest";
	}

	 

} // class
