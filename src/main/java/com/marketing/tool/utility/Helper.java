package com.marketing.tool.utility;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.marketing.tool.domain.User;
import com.marketing.tool.domain.UserProfileType;
import com.marketing.tool.service.LoginUserService;

@Service
public class Helper {

	@Autowired
	
	private LoginUserService loginUserService;
	public static String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if(principal!=null) {
			if (principal instanceof UserDetails) {
				userName = ((UserDetails)principal).getUsername();
			} else {
				userName = principal.toString();
			}
		}
		
		return userName;
	}
	
	public User getPrincipalUser() {
		User user = loginUserService.findByEmailId(Helper.getPrincipal()); 
		return user;
	}
	
	public static UserProfileType getRole(){
		UserProfileType role = null;
		Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
		
		if(authorities!=null) {
			for (GrantedAuthority grantedAuthority : authorities) {
	            if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
	            	role = UserProfileType.USER;
	                break;
	            } else if (grantedAuthority.getAuthority().equals("ROLE_REVIEWER")) {
	            	role = UserProfileType.REVIEWER;
	                break;
	            }else if (grantedAuthority.getAuthority().equals("ROLE_PUBLISHER")) {
	            	role = UserProfileType.PUBLISHER;
	                break;
	            }
	            else if (grantedAuthority.getAuthority().equals("ROLE_AUTHOR")) {
	            role = 	UserProfileType.AUTHOR;
	                break;
	            }
	            else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
	             role = UserProfileType.ADMIN;   
	                break;
	            }
	        }
		}
		
		return role;
	}
}
