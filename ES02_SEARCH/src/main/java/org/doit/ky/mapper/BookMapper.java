package org.doit.ky.mapper;

import java.util.List;

import org.doit.ky.domain.BookDTO;

public interface BookMapper {
  // 조회
  List<BookDTO> list();
  
  // 상세보기
  BookDTO get(String seq);
  
  // 추가
  void add(BookDTO dto);

}
