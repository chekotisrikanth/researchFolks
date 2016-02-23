package com.marketing.tool.service;

import java.util.List;

import com.marketing.tool.domain.Role;

public interface RoleService {
	
	List<Role> loadAllRoles();

	Role findById(Integer id);
	Role findByRole(String role);
}
