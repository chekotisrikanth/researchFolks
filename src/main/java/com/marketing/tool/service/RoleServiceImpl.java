package com.marketing.tool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.marketing.tool.domain.Role;
import com.marketing.tool.repository.RoleRepository;

@Service
@Validated
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepositoryRepository;

	@Override
	public List<Role> loadAllRoles() {
		return roleRepositoryRepository.findAll();
	}

	@Override
	public Role findById(Integer id) {
		return roleRepositoryRepository.findById(id);
	}

	@Override
	public Role findByRole(String role) {
		return roleRepositoryRepository.findByRole(role);
	}
	
	

}
