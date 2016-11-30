package com.marketing.tool.service;

import java.util.List;

import com.marketing.tool.domain.User;
import com.marketing.tool.domain.master.Keyskills;

public interface LoginUserService {
	
	//List<User> loadAllRoles();

	User findById(Integer id);
	//Role findByRole(String role);

	User findByEmailId(String emailId);
	
	List<User> findByAccountType(String accountType);
	
	
	
}
