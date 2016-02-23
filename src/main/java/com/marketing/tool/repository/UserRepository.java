package com.marketing.tool.repository;


import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.marketing.tool.domain.User;

@NoRepositoryBean
public interface UserRepository<T extends User> extends Repository<T , String> {

	T findByEmailId(String emailId);
	T save(User user);
	List<T> findAll();
	//T findBYEmailIdAndPassword();
	
}
