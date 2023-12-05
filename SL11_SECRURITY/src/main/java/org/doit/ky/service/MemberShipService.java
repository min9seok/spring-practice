package org.doit.ky.service;

import java.sql.SQLException;

import org.doit.ky.domain.NoticeVO;


public interface MemberShipService {
	
	void insertAndPointUpOfMember(NoticeVO vo, String id) throws ClassNotFoundException, SQLException;
}
