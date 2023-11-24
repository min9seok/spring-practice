package org.doit.ky.mapper.scott;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.doit.ky.domain.DeptDTO;
import org.doit.ky.domain.EmpDTO;

public interface EmpMapper {
	
	List<EmpDTO> selectEmp(ArrayList<Integer> deptnos);
		
}
