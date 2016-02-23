package com.marketing.tool.service;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.marketing.tool.domain.User;
import com.marketing.tool.domain.UserProfileType;
import com.marketing.tool.repository.AuthorRepository;
import com.marketing.tool.repository.RoleRepository;

@Service
@Validated
public class AuthorServiceImpl extends UserServiceImpl implements AuthorService {

	@Autowired
	RoleRepository roleRepository;
	
	@Inject
	public AuthorServiceImpl(AuthorRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

	
	@Transactional
	public User save(@NotNull @Valid final User user) { 
		user.setAccountType(UserProfileType.AUTHOR.getUserProfileType());
		return super.save(user);
	}
}
