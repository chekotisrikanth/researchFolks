package com.marketing.tool.service;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.transaction.annotation.Transactional;

import com.marketing.tool.domain.User;
import com.marketing.tool.exception.UserAlreadyExistsException;
import com.marketing.tool.repository.UserRepository;
import com.marketing.tool.utility.FileUtils;
import com.marketing.tool.utility.SharedConstants;
import com.marketing.tool.utility.StringUtil;


public class UserServiceImpl implements UserService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	private final UserRepository<User> repository;

	@Autowired
	 private FileUtils fileUtils;
	
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
		
		try {
			String imageName = user.getEmailId();
			if(user.getProfiePic()!=null) {
				String fileName =	fileUtils.saveFile(user.getProfiePic(),imageName,SharedConstants.PROFILEPICS_FOLDER_PATH);
				user.setProfilePicName(fileName);
			}
			
		} catch (IOException e) {
			LOGGER.error("failed to upload profile pic");
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
