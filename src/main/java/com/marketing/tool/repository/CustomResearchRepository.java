package com.marketing.tool.repository;

import org.springframework.data.repository.Repository;

import com.marketing.tool.domain.CustomResearch;

public interface CustomResearchRepository extends Repository<CustomResearch,Integer>  {

	CustomResearch save(CustomResearch customResearch);
}
