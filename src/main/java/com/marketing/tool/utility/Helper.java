package com.marketing.tool.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.marketing.tool.domain.User;
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
}
