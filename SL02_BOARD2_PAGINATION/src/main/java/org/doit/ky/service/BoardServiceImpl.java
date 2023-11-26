package org.doit.ky.service;

import java.util.List;

import org.doit.ky.domain.BoardVO;
import org.doit.ky.domain.Criteria;
import org.doit.ky.mapper.BoardMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Service
@AllArgsConstructor // 스프링 4.3부터 생성자 DI에 의해서 자동으로 객체(의존) 주입
@Log4j
public class BoardServiceImpl implements BoardService {
	
//	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public List<BoardVO> getList() {
		log.info("> Impl getList");
		return this.boardMapper.getList();
	}

	@Override
	public void insert(BoardVO board) {
		log.info("> Impl insert");
//		this.boardMapper.insert(board);
		this.boardMapper.insertSelectKey(board);
		
	}

	@Override
	public BoardVO get(Long bno) {
		log.info("> Impl view");		
		return this.boardMapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		log.info("> Impl modify");		
		return this.boardMapper.update(board)==1;				
	}

	@Override
	public boolean remove(Long bno) {
		log.info("> Impl delete");
		return this.boardMapper.delete(bno)==1;
	}

	@Override
	public List<BoardVO> getListWithPaging(Criteria criteria) {
		log.info("> Impl getListWithPaging");
		return this.boardMapper.getListWithPaging(criteria);
	}

	@Override
	public int getTotal(Criteria criteria) {
		log.info("> Impl getTotal");
		return this.boardMapper.getTotalCount(criteria);
	}

}
