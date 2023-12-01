package org.doit.ky.mapper;


import java.sql.SQLException;

import java.util.List;

import org.doit.ky.domain.NoticeVO;
import org.springframework.transaction.annotation.Transactional;

// @Transactional //인터페이스 전체 해당
public interface NoticeMapper {
	
	// 공지사항 총 갯수
	public int getCount(String field, String query) throws ClassNotFoundException, SQLException;
	// 목록
	public List<NoticeVO> getNotices(int page, String field, String query) throws ClassNotFoundException, SQLException;
	// 삭제
	public int delete(String seq) throws ClassNotFoundException, SQLException;
	// 수정	
	public int update(NoticeVO notice) throws ClassNotFoundException, SQLException;
	// 조회
	public NoticeVO getNotice(String seq) throws ClassNotFoundException, SQLException;
	// 추가	
	public int insert(NoticeVO vo) throws ClassNotFoundException, SQLException;
	
	// 트랜젝션 처리
//	@Transactional //선언 처리메서드 해당  
//	public void insertAndPointUpOfMember(NoticeVO vo, String id) throws ClassNotFoundException, SQLException;
	
	public void hithp(String seq) throws ClassNotFoundException, SQLException;
	public int getHit(String seq) throws ClassNotFoundException, SQLException;
	
}
