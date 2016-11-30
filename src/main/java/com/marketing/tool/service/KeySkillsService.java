package com.marketing.tool.service;

import java.util.List;

import com.marketing.tool.domain.master.Keyskills;

public interface KeySkillsService {
	
	List<Keyskills> loadAllKeyskills();

	Keyskills findById(Integer id);
	Keyskills findByName(String name);
} 
