package org.doit.ky.service;

import java.sql.SQLException;

import org.doit.ky.domain.NoticeVO;
import org.doit.ky.persistence.NoticeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberShipServiceImpl implements MemberShipService {
	
	@Autowired
	private NoticeDao dao;
	
	@Override // 애노테이션 트랜잭션 처리 + 전파 방식 처리
//	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED )
	public void insertAndPointUpOfMember(NoticeVO vo, String id) throws ClassNotFoundException, SQLException {
		
		this.dao.insert(vo);
		vo.setTitle(vo.getTitle()+"-2");
		this.dao.insert(vo);
							
	}

}
