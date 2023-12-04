package org.doit.ky.service;

import org.doit.ky.domain.Criteria;
import org.doit.ky.domain.ReplyPageDTO;
import org.doit.ky.domain.ReplyVO;
import org.springframework.stereotype.Service;

@Service
public interface ReplyService {

//	int insert(ReplyVO vo);
	int register(ReplyVO vo);
	
//	ReplyVO read(Long rno);
	ReplyVO get(Long rno);
	
//	int delete(Long rno);
	int remove(Long rno);
	
//	int update(ReplyVO reply); 
	int modify(ReplyVO vo);
	
//	List<ReplyVO> getListWithPaging(@Param("cri") Criteria cri, @Param("bno")Long bno);
//	ReplyPageDTO = List<ReplyVO> + getCountByBno 
	ReplyPageDTO getListPage(Criteria cri, Long bno);
	

	

}
