package org.doit.ik.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpVO {
	
	private String empno;
	private String ename;	
	private int idCheckResult;
	
}
