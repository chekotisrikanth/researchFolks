package com.marketing.tool.service;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import com.marketing.tool.domain.User;
import com.marketing.tool.exception.UserAlreadyExistsException;
import com.marketing.tool.repository.UserRepository;


public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	private final UserRepository<User> repository;

	@Inject
	public UserServiceImpl(final UserRepository repository) {
		this.repository = repository;
	}

	@Transactional
	public User save(@NotNull @Valid final User user) {
		LOGGER.debug("Creating {}", user);
		User existing = repository.findByEmailId(user.getEmailId());
		if (existing != null) {
			throw new UserAlreadyExistsException(
					String.format("There already exists a User with id=%s", user.getId()));
		}
		return repository.save(user);
	}

	  @Override
	    @Transactional(readOnly = true)
	    public List<User> getList() {
	        LOGGER.debug("Retrieving the list of all users");
	        return repository.findAll();
	    }
	/*@Override
	 public User loadUserByEmailId(String email) {
		return repository.findByEmailId(email);
	 }*/
	  
	  
}
