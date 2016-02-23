package com.marketing.tool.service;

import java.util.List;

import com.marketing.tool.domain.User;

public interface UserService {

	User save(User user);

	List<User> getList();
	
	//User loadUserByEmailId(String email);
	
	
}
