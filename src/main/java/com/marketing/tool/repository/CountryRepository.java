package com.marketing.tool.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.marketing.tool.domain.master.Country;

public interface CountryRepository extends Repository<Country,Integer> {

	List<Country> findAll();
	
}
