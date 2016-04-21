package com.marketing.tool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.tool.domain.MasterIndustries;
import com.marketing.tool.repository.MasterIndustriesRepository;

@Service
public class MasterIndustriesServiceImpl implements MasterIndustriesService {

	@Autowired
	private MasterIndustriesRepository repo;
	
	public List<MasterIndustries> findAllIndustries() {
		return repo.findAllIndustries();
		
	}
}
