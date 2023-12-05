package org.doit.ky.mapper;


import java.sql.SQLException;

import org.doit.ky.domain.MemberVO;

public interface MemberMapper {
	public MemberVO getMember(String id) throws ClassNotFoundException, SQLException;

	public int insert(MemberVO member) throws ClassNotFoundException, SQLException;
	
}
