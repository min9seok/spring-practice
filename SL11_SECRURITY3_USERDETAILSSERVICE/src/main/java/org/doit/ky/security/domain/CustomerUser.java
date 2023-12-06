package org.doit.ky.security.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.doit.ky.domain.MemberVO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class CustomerUser extends User{

	private MemberVO memberVO;
	
	private static final long serialVersionUID = -1009490482366717321L;

	public CustomerUser(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);

	}
	public CustomerUser(MemberVO vo) {
		super(vo.getId(), vo.getPwd()
				 // List<AuthVO>  -> 
	            //                    Collection<? extends GrantedAuthority> authorities
	            , vo.getAuthlist().stream().map( auth->new SimpleGrantedAuthority( auth.getAuthority() ) ).collect( Collectors.toList() ));
		this.memberVO = vo;
	}
}
