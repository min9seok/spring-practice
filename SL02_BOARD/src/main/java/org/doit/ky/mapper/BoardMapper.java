package org.doit.ky.mapper;

import java.util.List;

import org.doit.ky.domain.BoardVO;

public interface BoardMapper {

	// 1. 글목록
	List<BoardVO> getList();
	
	// 2. 글쓰기
	void insert(BoardVO board);
	void insertSelectKey(BoardVO board);
	
	// 3. 글보기
	BoardVO read(Long bno);
	
	// 4. 글수정
	int update(BoardVO board);
	
	// 5. 글삭제
	int delete(Long bno);
}
