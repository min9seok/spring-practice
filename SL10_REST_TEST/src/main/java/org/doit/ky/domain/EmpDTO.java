package org.doit.ky.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpDTO {
	
	private String empno;
	private String ename;
	private String job;	
	private String mgr;
	private Date hiredate;
	private double sal;
	private double comm;
	private int deptno;
	
}
