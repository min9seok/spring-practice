package org.doit.ik;

import java.util.List;

import org.doit.ik.domain.DeptDTO;
import org.doit.ik.domain.EmpDTO;
import org.doit.ik.domain.EmpVO;
import org.doit.ik.mapper.DeptEmpMapper;
import org.doit.ik.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class DeptEmpAjaxController {

	@Setter(onMethod=@__({@Autowired}))
	private DeptEmpMapper deptEmpMapper;
	
	//@GetMapping(value = "/deptEmp/{deptno}"
	//		, produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_UTF8_VALUE})
	@GetMapping(value = "/deptEmp/{deptno}")
	public ResponseEntity<List<EmpDTO>> getEmpList(
			@PathVariable("deptno") int deptno){
		log.info("> getEmpList... " );
		return new ResponseEntity<>( this.deptEmpMapper.selectEmp(deptno), HttpStatus.OK);		
	}

	 

} // class
