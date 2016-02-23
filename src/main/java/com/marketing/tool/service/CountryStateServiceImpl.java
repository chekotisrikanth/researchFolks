package com.marketing.tool.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.marketing.tool.domain.Country;
import com.marketing.tool.domain.State;
import com.marketing.tool.repository.CountryRepository;
import com.marketing.tool.repository.StateRepository;

@Service
@Validated
public class CountryStateServiceImpl implements CountryStateService {

	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	
	@Override
	public List<State> findByCountryId(Integer countryId) {
			return stateRepository.findByCountryId(countryId);
	}

	@Override
	public List<Country> listAllCountries() {
		return countryRepository.findAll();
	}

}
