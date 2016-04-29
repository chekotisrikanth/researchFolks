package com.marketing.tool.service;

import java.util.List;

import com.marketing.tool.domain.Keyskills;
import com.marketing.tool.domain.User;

public interface LoginUserService {
	
	//List<User> loadAllRoles();

	User findById(Integer id);
	//Role findByRole(String role);

	User findByEmailId(String emailId);
	
	List<User> findByAccountType(String accountType);
	
	
	
}
