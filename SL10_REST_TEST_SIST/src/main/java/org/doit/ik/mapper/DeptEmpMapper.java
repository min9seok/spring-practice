package org.doit.ik.mapper;

import java.util.List;

import org.doit.ik.domain.DeptDTO;
import org.doit.ik.domain.EmpDTO;

public interface DeptEmpMapper {
	
	List<DeptDTO> selectDept();
	List<EmpDTO> selectEmp(int deptno);

}
