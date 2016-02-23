package com.marketing.tool.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly=true)
public class LoginUserDetailsService implements UserDetailsService {

	@Autowired
	private LoginUserService loginUserService;

	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String emailId)
			throws UsernameNotFoundException {
		com.marketing.tool.domain.User user = loginUserService.findByEmailId(emailId);
		System.out.println("User : "+user);
		if(user==null){
			System.out.println("User not found");
			throw new UsernameNotFoundException("Username not found");
		}
			return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(), 
				 user.getUserstatus().equals("Active"), true, true, true, getGrantedAuthorities(user));
	}

	
	private List<GrantedAuthority> getGrantedAuthorities(com.marketing.tool.domain.User user){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		
		/*for(UserProfile userProfile : user.getAccountType()){
			System.out.println("UserProfile : "+userProfile);
			authorities.add(new SimpleGrantedAuthority(userProfile.getType()));
		}*/
		authorities.add(new SimpleGrantedAuthority("ROLE_"+user.getAccountType()));
		System.out.print("authorities :"+authorities);
		return authorities;
	}
	


}
