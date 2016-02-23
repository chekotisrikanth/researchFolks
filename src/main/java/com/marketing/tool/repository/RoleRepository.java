package com.marketing.tool.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.marketing.tool.domain.Role;

public interface RoleRepository extends Repository<Role,Integer> {

	//@Query("SELECT skill FROM Keyskills)")
	//List<String> findAllSkillNames();
	
	List<Role> findAll();
	
	Role findById(Integer id);
	Role findByRole(String role);
}
