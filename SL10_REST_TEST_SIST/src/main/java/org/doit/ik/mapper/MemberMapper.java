package org.doit.ik.mapper;

import org.doit.ik.domain.DeptDTO;

public interface MemberMapper {
	
	int idCheck(String empno);
	int insertDept(DeptDTO dto);
	int deleteDept(int deptno);
	
}
