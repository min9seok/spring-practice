package org.doit.ik;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.doit.ik.domain.DeptDTO;
import org.doit.ik.domain.EmpVO;
import org.doit.ik.mapper.MemberMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

 

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class HomeAjaxController {
	
	// @Autowired
	@Setter(onMethod=@__({@Autowired}))
	private MemberMapper memberMapper;
	
	/*
	@GetMapping("/idCheck")
	public int idCheck(String empno) {
		
		log.info("> /idcheck... GET - Ajax : " + empno );		
		return this.memberMapper.idCheck(empno); // 1(ID 중복 O)  0(ID 사용가능)
		
	}
	*/
	
	@GetMapping("/idCheck")
	public EmpVO idCheck(String empno) {
		
		log.info("> /idcheck... GET - Ajax : " + empno );		
		int idCheckResult =  this.memberMapper.idCheck(empno); // 1(ID 중복 O)  0(ID 사용가능)
		
		//     java Object
		return new EmpVO(empno, "홍길동", idCheckResult);
		
	}
	
	// "/scott/dept/new"
	// { "deptno":50, "dname":"부서명", "loc":"지역명"} json
	@PostMapping( value = "/scott/dept/new")
	public  ResponseEntity<String> insertDept( @RequestBody DeptDTO dto  ){
		log.info("> /scott/dept/now POST ...");
		int insertResult = this.memberMapper.insertDept(dto);
		// 응답결과물 + http 상태코드  : ResponseEntity
		return insertResult == 1 ? new ResponseEntity<>("SUCCESS", HttpStatus.OK)
				                 : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) ;
	}
	
	// "/scott/dept/50"
	@DeleteMapping(value = "/scott/dept/{deptno}", produces = { MediaType.TEXT_PLAIN_VALUE }) 
	public  ResponseEntity<String> deleteDept( @PathVariable("deptno") int deptno ){
		log.info("> /scott/dept/"+ deptno +"+ DELETE....."); 
		
		int deleteResult = this.memberMapper.deleteDept(deptno);
		// 응답결과물 + http 상태코드  : ResponseEntity
		return deleteResult == 1 ? new ResponseEntity<>("SUCCESS", HttpStatus.OK)
				                 : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR) ;
	}
	
	
}



/*
 * 
 * */






