package com.marketing.tool.service;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.marketing.tool.domain.Keyskills;
import com.marketing.tool.domain.User;
import com.marketing.tool.repository.AdminRepository;

@Service
@Validated
public class AdminServiceImpl extends UserServiceImpl implements AdminService {

	AdminRepository repository;
	
	@Value( "${defaultrole:user}" )
	String defaultRole;
	
	@Inject
	public AdminServiceImpl(AdminRepository repository) {
		super(repository);
		this.repository = repository;
	}

	@Transactional
	public User save(@NotNull @Valid final User user) { 
		/*Set<UserProfile> roles = new HashSet<UserProfile>();
		UserProfile profile = new UserProfile();
		if("user".equalsIgnoreCase(defaultRole)) {
			profile.setType(user.getAccountType());
		}else {
			profile.setType(UserProfileType.ADMIN.getUserProfileType());
		}
		roles.add(profile);
		user.setUserProfiles(roles);*/
		return super.save(user);
	}
	
	

}
