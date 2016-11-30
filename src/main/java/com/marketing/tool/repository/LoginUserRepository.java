package com.marketing.tool.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.marketing.tool.domain.User;
import com.marketing.tool.domain.master.Keyskills;

public interface LoginUserRepository extends Repository<User,Integer> {

	List<User> findAll();
	//List<User> findByCountryId(Integer countryId);
    User findById(Integer id);	
    User findByEmailId(String emailId);
    List<User> findByAccountType(String accountType);
    
	
}
