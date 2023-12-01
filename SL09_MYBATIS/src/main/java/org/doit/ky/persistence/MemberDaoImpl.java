package org.doit.ky.persistence;


import java.sql.SQLException;

import org.doit.ky.domain.MemberVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import lombok.extern.log4j.Log4j;

@Repository
@Log4j
public class MemberDaoImpl implements MemberDao  {
		
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public MemberVO getMember(String id) throws ClassNotFoundException, SQLException
	{
		String sql = "SELECT * "
				   + "FROM MEMBER "
				   + "WHERE id= :id";
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("id",id);
		return this.template.queryForObject(sql, parameterSource, new BeanPropertyRowMapper<MemberVO>(MemberVO.class));
	}
	
	public int insert(MemberVO member) throws ClassNotFoundException, SQLException
	{
		String sql = "INSERT INTO MEMBER(id, PWD, NAME, GENDER, BIRTH, IS_LUNAR, CPHONE, EMAIL, HABIT, REGDATE) "
				+ " VALUES( :id, :pwd, :name, :gender, :birth, :is_lunar, :cphone, :email, :habit, SYSDATE)";
		
		SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(member);
		return this.template.update(sql, parameterSource);
	}
}
