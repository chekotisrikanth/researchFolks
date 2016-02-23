package com.marketing.tool.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.marketing.tool.domain.State;

public interface StateRepository extends Repository<State,Integer> {

	List<State> findAll();
	List<State> findByCountryId(Integer countryId);
	
	
}
