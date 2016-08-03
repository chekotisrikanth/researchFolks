package com.marketing.tool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.marketing.tool.domain.Keyskills;
import com.marketing.tool.repository.KeyskillsRepository;

@Service
@Validated
public class KeyskillsServiceImpl implements KeySkillsService {

	@Autowired
	private KeyskillsRepository keyskillsRepositoryRepository;

	@Override
	public List<Keyskills> loadAllKeyskills() {
		return keyskillsRepositoryRepository.findAll();
	}

	@Override
	public Keyskills findById(Integer id) {
		return keyskillsRepositoryRepository.findById(id);
	}

	@Override
	public Keyskills findByName(String name) {
		return keyskillsRepositoryRepository.findBySkill(name);
	}
	
	

}
