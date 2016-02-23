package com.marketing.tool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.marketing.tool.domain.Keyskills;

public interface KeyskillsRepository extends Repository<Keyskills,Integer> {

	@Query("SELECT skill FROM Keyskills)")
	List<String> findAllSkillNames();
	
	List<Keyskills> findAll();
	
	Keyskills findById(Integer id);
}
