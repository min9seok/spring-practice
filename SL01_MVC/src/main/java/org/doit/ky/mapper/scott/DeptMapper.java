package org.doit.ky.mapper.scott;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Select;
import org.doit.ky.domain.DeptDTO;

public interface DeptMapper {
	
	ArrayList<DeptDTO> selectDept();
	int insertDept(DeptDTO dto);
	int deleteDept(int deptno);
		
}
