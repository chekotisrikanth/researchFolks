package com.marketing.tool.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.marketing.tool.domain.CustomResearch;
import com.marketing.tool.repository.CustomResearchRepository;

@Service
@Validated
public class CustomResearchServiceImpl implements CustomResearchService {

	@Autowired
	CustomResearchRepository repo;

	public CustomResearch save(CustomResearch customResearch) {
		return repo.save(customResearch);
	}
}
