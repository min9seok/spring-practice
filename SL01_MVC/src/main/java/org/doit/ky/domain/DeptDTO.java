package org.doit.ky.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeptDTO {
	private int deptno;
	private String dname;
	private String loc;
	
	private int numberOfEmps;
	
	
}
