package org.doit.ky.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.doit.ky.domain.Criteria;
import org.doit.ky.domain.ReplyVO;
import org.springframework.stereotype.Repository;

@Repository
public interface ReplyMapper {
	
	int insert(ReplyVO vo);
	ReplyVO read(Long rno);
	int delete(Long rno);
	int update(ReplyVO reply);

	// 페이징 처리가 된 댓글 목록을 반환하는 메서드 
	List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno")Long bno);
	int getCountByBno(Long bno);
}
