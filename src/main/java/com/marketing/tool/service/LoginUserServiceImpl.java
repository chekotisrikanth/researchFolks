package com.marketing.tool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.marketing.tool.domain.Keyskills;
import com.marketing.tool.domain.User;
import com.marketing.tool.repository.LoginUserRepository;

@Service
@Validated
public class LoginUserServiceImpl implements LoginUserService {

	@Autowired
	private LoginUserRepository loginUserRepositoryRepository;


	@Override
	public User findById(Integer id) {
		return loginUserRepositoryRepository.findById(id);
	}
	
	@Override
	public User findByEmailId(String emailId) {
		return loginUserRepositoryRepository.findByEmailId(emailId);
	}

	@Override
	public List<User> findByAccountType(String accountType) {
		return loginUserRepositoryRepository.findByAccountType(accountType);
	}

	

}
