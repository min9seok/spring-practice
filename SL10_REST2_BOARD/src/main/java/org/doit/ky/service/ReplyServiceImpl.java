package org.doit.ky.service;

import org.doit.ky.domain.Criteria;
import org.doit.ky.domain.ReplyPageDTO;
import org.doit.ky.domain.ReplyVO;
import org.doit.ky.mapper.ReplyMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor 
@Log4j
public class ReplyServiceImpl implements ReplyService {
	
	private ReplyMapper replyMapper;
	
	@Override	
	public int register(ReplyVO vo) {
		log.info("register" + vo);
		return this.replyMapper.insert(vo);
	}

	@Override
	public ReplyVO get(Long rno) {
		log.info("get" + rno);
		return this.replyMapper.read(rno);
	}

	@Override
	public int remove(Long rno) {
		log.info("remove" + rno);
		return this.replyMapper.delete(rno);
	}

	@Override
	public int modify(ReplyVO vo) {
		log.info("modify" + vo);
		return this.replyMapper.update(vo);
	}

	@Override
	public ReplyPageDTO getListPage(Criteria cri, Long bno) {
		log.info("getListPage" + bno);		
		return new ReplyPageDTO(this.replyMapper.getListWithPaging(cri, bno), this.replyMapper.getCountByBno(bno));
	}
	
}
