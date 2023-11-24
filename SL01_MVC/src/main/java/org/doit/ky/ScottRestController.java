package org.doit.ky;

import org.doit.ky.domain.DeptDTO;
import org.doit.ky.mapper.scott.DeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;

// Ajax 컨트롤러
@RestController
@Log4j
@RequestMapping("/scott/dept/*")
public class ScottRestController {
	
	@Autowired
	private DeptMapper deptMapper;
	
	@PostMapping(value = "/new")
	public ResponseEntity<String> insertDept(@RequestBody DeptDTO dto){
		log.info("> /scott/dept/new ");
		int result = this.deptMapper.insertDept(dto);
		return result==1 ?  
	            new ResponseEntity<>("SUCCESS", HttpStatus.OK) 
	            :   new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)    ;
		
	}
	@DeleteMapping(value = "/{deptno}", produces = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<String> deleteDept(@PathVariable("deptno") int deptno){
		log.info("> /scott/dept/"+deptno);
		int result = this.deptMapper.deleteDept(deptno);
		return result==1 ?  
	            new ResponseEntity<>("SUCCESS", HttpStatus.OK) 
	            :   new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR)    ;
		
	} 
}
