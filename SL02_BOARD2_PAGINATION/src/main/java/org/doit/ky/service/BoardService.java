package org.doit.ky.service;

import java.util.List;

import org.doit.ky.domain.BoardVO;

public interface BoardService {

	// 1. 글목록
	List<BoardVO> getList();

	// 2. 글쓰기
	void insert(BoardVO board);
	
	// 3. 글보기
	BoardVO get(Long bno);
	
	// 4. 글수정
	boolean modify(BoardVO board);
	
	// 5. 글삭제
	boolean remove(Long bno);

}
