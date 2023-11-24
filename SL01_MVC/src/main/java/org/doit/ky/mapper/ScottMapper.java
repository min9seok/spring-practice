package org.doit.ky.mapper;

import org.apache.ibatis.annotations.Select;

public interface ScottMapper {
	String getTime();
	
	@Select("SELECT sysdate + 1 FROM dual")
	String getNextTime();
}
