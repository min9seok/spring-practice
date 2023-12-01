package org.doit.ky;

import java.util.List;

import org.doit.ky.domain.DeptDTO;
import org.doit.ky.domain.EmpDTO;
import org.doit.ky.domain.EmpVO;
import org.doit.ky.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.MediaType;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RestController
@Log4j
public class HomeAjaxController {
	
	@Setter(onMethod=@__({@Autowired}))
	private MemberMapper mapper;
	
//	@GetMapping("/idCheck")
//	public int idCheck(String empno) throws Exception {
//		log.info("idCheck : " + empno);
//		return this.mapper.idCheck(empno);
//	}
	
	@GetMapping("/idCheck")
	public EmpVO idCheck(String empno) throws Exception {
		log.info("idCheck : " + empno);
		int idCheckResult = this.mapper.idCheck(empno);
		
		return new EmpVO(empno,"홍길동",idCheckResult);
		
	}
	
	@PostMapping("/scott/dept/new")
	public ResponseEntity<String> insertDept(@RequestBody DeptDTO dto) throws Exception {
		log.info("insertDept");
		int count = this.mapper.insertDept(dto);
		// 결과 + http 상태코드
		return count==1? new ResponseEntity<>("SUCCESS", HttpStatus.OK): new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping(value = "/scott/dept/{deptno}", produces = {MediaType.TEXT_PLAIN_VALUE })	
	public ResponseEntity<String> deleteDept(@PathVariable("deptno") int deptno ) throws Exception {
		log.info("deleteDept");
		int count = this.mapper.deleteDept(deptno);
		// 결과 + http 상태코드
		return count==1? new ResponseEntity<>("SUCCESS", HttpStatus.OK): new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/selectemp")
	public List<EmpDTO> selectEmp(int deptno, Model model) throws Exception {
		log.info("selectEmp : " + deptno);
		List<EmpDTO> emp = this.mapper.selectEmp(deptno);
		model.addAttribute("emp",emp);
		return this.mapper.selectEmp(deptno);
					
	}

	
}
