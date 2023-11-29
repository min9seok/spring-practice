package org.doit.ky.persistence;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.doit.ky.domain.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import lombok.extern.log4j.Log4j;

@Repository
public class NoticeDaoImpl implements NoticeDao  {

	@Autowired
	private NamedParameterJdbcTemplate template;
	
	
	
	public int getCount(String field, String query) throws ClassNotFoundException, SQLException
	{
		String sql = " SELECT COUNT(*) CNT "
				   + " FROM NOTICES "
				   + " WHERE "+field+" LIKE :query";
		
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("query","%"+query+"%");
		return this.template.queryForObject(sql, parameterSource, Integer.class);

	}

	public List<NoticeVO> getNotices(int page, String field, String query) throws ClassNotFoundException, SQLException
	{					

		int srow = 1 + (page-1)*15; // 1, 16, 31, 46, 61, ... an = a1 + (n-1)*d
		int erow = 15 + (page-1)*15; //15, 30, 45, 60, 75, ...

		String sql = "SELECT * "
				+ " FROM "
				+ " 		(SELECT ROWNUM NUM, N.* "
				+ " 			FROM "
				+ " 				(SELECT * "
				+ " 				FROM NOTICES "
				+ " 				WHERE "+field+" LIKE :query "
				+ " 				ORDER BY REGDATE DESC "
				+ "					) N "
				+ "			) "
				+ " WHERE NUM BETWEEN :srow AND :erow ";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("query","%"+query+"%");
		map.put("srow",srow);
		map.put("erow",erow);
		return this.template.query(sql, map, new BeanPropertyRowMapper<NoticeVO>(NoticeVO.class));
		
	}

	public int delete(String seq) throws ClassNotFoundException, SQLException
	{

		String sql = " DELETE FROM NOTICES "
				   + " WHERE SEQ = :seq";
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("seq",seq);
		return this.template.update(sql, parameterSource);
		
	}

	public int update(NoticeVO notice) throws ClassNotFoundException, SQLException{

		String sql = " UPDATE NOTICES "
				   + " SET TITLE = :title, CONTENT = :content, FILESRC = :filesrc "
				   + " WHERE SEQ = :seq ";
		
		 SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(notice);
		 return this.template.update(sql, parameterSource);
		/*
	      MapSqlParameterSource parameterSource = new MapSqlParameterSource();
	      parameterSource.addValue("title", notice.getTitle());
	      parameterSource.addValue("content", notice.getContent());
	      parameterSource.addValue("filesrc",notice.getFilesrc());
	      parameterSource.addValue("seq", notice.getSeq() );
	      
	      return this.npJdbcTemplate.update(sql, parameterSource);
	      */
		 
	}

	public NoticeVO getNotice(String seq) throws ClassNotFoundException, SQLException
	{
		String sql = " SELECT * "
				   + " FROM NOTICES "
				   + " WHERE SEQ = :seq ";
		
		MapSqlParameterSource parameterSource = new MapSqlParameterSource();
		parameterSource.addValue("seq",seq);
		return this.template.queryForObject(sql, parameterSource, new BeanPropertyRowMapper<NoticeVO>(NoticeVO.class));
									  
	}

	public int insert(NoticeVO vo) throws ClassNotFoundException, SQLException {
		String sql = " INSERT INTO NOTICES(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) "
				   + " VALUES( (SELECT NVL(MAX(TO_NUMBER(SEQ))+1,1) FROM NOTICES), :title, :content, :writer, SYSDATE, 0, :filesrc)";
		
		 SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(vo);
		return this.template.update(sql, parameterSource);
				
	}
}
