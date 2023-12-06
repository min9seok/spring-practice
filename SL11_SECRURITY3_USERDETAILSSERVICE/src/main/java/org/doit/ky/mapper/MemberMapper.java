package org.doit.ky.mapper;


import java.sql.SQLException;

import org.apache.ibatis.annotations.Param;
import org.doit.ky.domain.MemberVO;

public interface MemberMapper {
	//로그인
	public MemberVO getMember(String id) throws ClassNotFoundException, SQLException;
	//회원가입
	public int insert(MemberVO member) throws ClassNotFoundException, SQLException;
	// 로그인 + 권한
	public MemberVO read(@Param("userid") String userid);
	
}
