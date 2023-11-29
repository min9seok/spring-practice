package org.doit.ky.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.doit.ky.domain.NoticeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	
	public int getCount(String field, String query) throws ClassNotFoundException, SQLException
	{
		String sql = " SELECT COUNT(*) CNT "
				   + " FROM NOTICES "
				   + " WHERE "+field+" LIKE ?";
		
		return this.jdbcTemplate.queryForObject(sql, Integer.class,"%"+query+"%");


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
				+ " 				WHERE "+field+" LIKE ? "
				+ " 				ORDER BY REGDATE DESC "
				+ "					) N "
				+ "			) "
				+ " WHERE NUM BETWEEN ? AND ?";

		return this.jdbcTemplate.query(sql
				              , new Object[] { "%"+query+"%", srow, erow}
		                      , new BeanPropertyRowMapper<NoticeVO>(NoticeVO.class) );
	}

	public int delete(String seq) throws ClassNotFoundException, SQLException
	{

		String sql = " DELETE FROM NOTICES "
				   + " WHERE SEQ=?";

		return this.jdbcTemplate.update(sql, seq);
	}

	public int update(NoticeVO notice) throws ClassNotFoundException, SQLException{

		String sql = " UPDATE NOTICES "
				   + " SET TITLE=?, CONTENT=?, FILESRC=? "
				   + " WHERE SEQ=?";

		return this.jdbcTemplate.update(sql, notice.getTitle(),notice.getContent(),notice.getFilesrc(),notice.getSeq());
	}

	public NoticeVO getNotice(String seq) throws ClassNotFoundException, SQLException
	{
		String sql = " SELECT * "
				   + " FROM NOTICES "
				   + " WHERE SEQ= ?";
		return this.jdbcTemplate.queryForObject(sql
				                              , new Object[] {seq}
											  , new BeanPropertyRowMapper<NoticeVO>(NoticeVO.class) );
	}

	public int insert(NoticeVO vo) throws ClassNotFoundException, SQLException {
		String sql = " INSERT INTO NOTICES(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) "
				   + " VALUES( (SELECT NVL(MAX(TO_NUMBER(SEQ))+1,1) FROM NOTICES), ?, ?, ?, SYSDATE, 0, ?)";
		
		return this.jdbcTemplate.update(sql,vo.getTitle(),vo.getContent(),vo.getWriter(),vo.getFilesrc());
		
	}
}
