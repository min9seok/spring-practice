package org.doit.ky.security;

import org.doit.ky.domain.MemberVO;
import org.doit.ky.mapper.MemberMapper;
import org.doit.ky.security.domain.CustomerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j;

@Component("customUserDetailsService")
@Log4j
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.warn("loadUserByUsername : " + username);
		MemberVO vo = this.mapper.read(username);
		log.warn("loadUserByUsername read : " + vo);
		
		return vo==null?null:new CustomerUser(vo);
	}

}
