package com.marketing.tool.service;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.marketing.tool.domain.User;
import com.marketing.tool.domain.UserProfileType;
import com.marketing.tool.repository.CustomerRepository;

@Service
@Validated
public class CustomerServiceImpl extends UserServiceImpl implements CustomerService {

	@Inject
	public CustomerServiceImpl(CustomerRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public User save(@NotNull @Valid final User user) { 
		user.setAccountType(UserProfileType.USER.toString());
		return super.save(user);
	}
	
}
