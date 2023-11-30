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
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import lombok.extern.log4j.Log4j;

@Repository
public class NoticeDaoImpl implements NoticeDao  {

	@Autowired
	private NamedParameterJdbcTemplate template;	
	
//	@Autowired
//	private DataSourceTransactionManager transactionManager;
	
//	@Autowired
//	private TransactionTemplate transactionTemplate;
	
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
	
	// 공지사항 등록 + 작성자 포인트 증가
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
	public int insert(NoticeVO vo) throws ClassNotFoundException, SQLException { // 트랜잭션 전파 방식  
		// 1. 공지사항 작성
		String sql  = " INSERT INTO NOTICES(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) "
				    + " VALUES( (SELECT NVL(MAX(TO_NUMBER(SEQ))+1,1) FROM NOTICES), :title, :content, :writer, SYSDATE, 0, :filesrc)";
		// 1
		 SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(vo);
		 template.update(sql, parameterSource);
		// 2. 작성자 포인트 증가		
		String sql2 = " UPDATE member "
			        + " SET point = point + 1 "
			        + " WHERE id = :id ";
		// 2
		 MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
		 mapSqlParameterSource.addValue("id","kmys");
     	 int count = template.update(sql2, mapSqlParameterSource);
     	 return count;				
	}
	
//	@Override // 애노테이션 트랜잭션 처리 + 전파 방식 처리
//	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED )
//	public void insertAndPointUpOfMember(NoticeVO vo, String id) throws ClassNotFoundException, SQLException {
//		
//		insert(vo);
//		vo.setTitle(vo.getTitle()+"-2");
//		insert(vo);
//							
//	}
	
//	public int insert(NoticeVO vo) throws ClassNotFoundException, SQLException { // 기존 자료 
//		String sql = " INSERT INTO NOTICES(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) "
//				   + " VALUES( (SELECT NVL(MAX(TO_NUMBER(SEQ))+1,1) FROM NOTICES), :title, :content, :writer, SYSDATE, 0, :filesrc)";
//		
//		 SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(vo);
//		return this.template.update(sql, parameterSource);
//				
//	}
	
//	@Override // 애노테이션 트랜잭션 처리
//	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED )
//	public void insertAndPointUpOfMember(NoticeVO vo, String id) throws ClassNotFoundException, SQLException {
//		// 1. 공지사항 작성
//		String sql  = " INSERT INTO NOTICES(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) "
//				    + " VALUES( (SELECT NVL(MAX(TO_NUMBER(SEQ))+1,1) FROM NOTICES), :title, :content, :writer, SYSDATE, 0, :filesrc)";
//		// 1
//		 SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(vo);
//		 template.update(sql, parameterSource);
//		// 2. 작성자 포인트 증가		
//		String sql2 = " UPDATE member "
//			        + " SET point = point + 1 "
//			        + " WHERE id = :id ";
//		// 2
//		 MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
//		 mapSqlParameterSource.addValue("id",id);
//     	 int count = template.update(sql2, mapSqlParameterSource);
//
//
//							
//	}
	
//	@Override // 선언적 트랜잭션 처리 
//	public void insertAndPointUpOfMember(NoticeVO vo, String id) throws ClassNotFoundException, SQLException {
//		// 1. 공지사항 작성
//		String sql  = " INSERT INTO NOTICES(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) "
//				    + " VALUES( (SELECT NVL(MAX(TO_NUMBER(SEQ))+1,1) FROM NOTICES), :title, :content, :writer, SYSDATE, 0, :filesrc)";
//		// 1
//		 SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(vo);
//		 template.update(sql, parameterSource);
//		// 2. 작성자 포인트 증가		
//		String sql2 = " UPDATE member "
//			        + " SET point = point + 1 "
//			        + " WHERE id = :id ";
//		// 2
//		 MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
//		 mapSqlParameterSource.addValue("id",id);
//     	 int count = template.update(sql2, mapSqlParameterSource);
//
//
//							
//	}
	
//	@Override // 트랜잭션 처리 + 탬플릿 사용
//	public void insertAndPointUpOfMember(NoticeVO vo, String id) throws ClassNotFoundException, SQLException {
//		// 1. 공지사항 작성
//		String sql  = " INSERT INTO NOTICES(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) "
//				    + " VALUES( (SELECT NVL(MAX(TO_NUMBER(SEQ))+1,1) FROM NOTICES), :title, :content, :writer, SYSDATE, 0, :filesrc)";
//		// 2. 작성자 포인트 증가		
//		String sql2 = " UPDATE member "
//			        + " SET point = point + 1 "
//			        + " WHERE id = :id ";
//		// p514 
//		//                                 WithoutResult : 리턴할 결과값이 없는 경우
//		this.transactionTemplate.execute(new TransactionCallbackWithoutResult() {
//					
//			protected void doInTransactionWithoutResult(TransactionStatus status) {		
//				// 1
//				 SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(vo);
//				 template.update(sql, parameterSource);
//				// 2
//				 MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
//				 mapSqlParameterSource.addValue("id",id);
//				int count = template.update(sql2, mapSqlParameterSource);
//			}
//		});							
//	}
	
//	@Override // 트랜잭션 처리
//	public void insertAndPointUpOfMember(NoticeVO vo, String id) throws ClassNotFoundException, SQLException {
//		// 1. 공지사항 작성
//		String sql  = " INSERT INTO NOTICES(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) "
//				    + " VALUES( (SELECT NVL(MAX(TO_NUMBER(SEQ))+1,1) FROM NOTICES), :title, :content, :writer, SYSDATE, 0, :filesrc)";
//		// 2. 작성자 포인트 증가		
//		String sql2 = " UPDATE member "
//			        + " SET point = point + 1 "
//			        + " WHERE id = :id ";
//		TransactionDefinition definition = new DefaultTransactionDefinition();
//		TransactionStatus status = this.transactionManager.getTransaction(definition );
//		try {
//			// 1
//			 SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(vo);
//			 this.template.update(sql, parameterSource);
//			// 2
//			 MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
//			 mapSqlParameterSource.addValue("id",id);
//			int count = this.template.update(sql2, mapSqlParameterSource);			
//			// 커밋
//			this.transactionManager.commit(status);
//		} catch (Exception e) {
//			e.printStackTrace();
//			this.transactionManager.rollback(status);
//			
//		}
//	}
	
//	@Override // 트랜잭션 미처리 
//	public void insertAndPointUpOfMember(NoticeVO vo, String id) throws ClassNotFoundException, SQLException {
//		// 1. 공지사항 작성
//		String sql = " INSERT INTO NOTICES(SEQ, TITLE, CONTENT, WRITER, REGDATE, HIT, FILESRC) "
//				   + " VALUES( (SELECT NVL(MAX(TO_NUMBER(SEQ))+1,1) FROM NOTICES), :title, :content, :writer, SYSDATE, 0, :filesrc)";
//		
//		 SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(vo);
//		 this.template.update(sql, parameterSource);
//		// 2. 작성자 포인트 증가
//		 sql = " UPDATE member "
//		     + " SET point = point + 1 "
//		     + " WHERE id = :id ";
//		 MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
//		 mapSqlParameterSource.addValue("id",id);
//		int count = this.template.update(sql, mapSqlParameterSource);
//	}
}
