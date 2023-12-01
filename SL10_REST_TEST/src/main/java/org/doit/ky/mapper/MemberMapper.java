package org.doit.ky.mapper;

import java.util.ArrayList;
import java.util.List;

import org.doit.ky.domain.DeptDTO;
import org.doit.ky.domain.EmpDTO;


public interface MemberMapper {
	
	int idCheck(String empno) throws Exception;
	
	int insertDept(DeptDTO dto) throws Exception;
	
	int deleteDept(int deptno) throws Exception;
	
	ArrayList<EmpDTO> selectEmp(int deptno) throws Exception;
		
	ArrayList<DeptDTO> selectDept() throws Exception;
	
	
	
}
