package com.marketing.tool.service;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.marketing.tool.domain.Author;
import com.marketing.tool.domain.Keyskills;
import com.marketing.tool.domain.User;
import com.marketing.tool.domain.UserProfileType;
import com.marketing.tool.repository.AuthorRepository;
import com.marketing.tool.repository.RoleRepository;

@Service
@Validated
public class AuthorServiceImpl extends UserServiceImpl implements AuthorService {

	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	AuthorRepository authorRepository;
	
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
	
	@Override
	public List<Author> findAuhtors(String country, List<Keyskills> skills)    {
		if(country==null || "any".equals(country) || "undefined".equals(country)) {
			return authorRepository.findByKeyskillsIn(skills);
		}
		return authorRepository.findByCountryAndKeyskillsIn(country, skills);
	}
}
