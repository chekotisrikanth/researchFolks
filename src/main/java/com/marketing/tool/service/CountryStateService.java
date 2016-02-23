package com.marketing.tool.service;

import java.util.List;

import com.marketing.tool.domain.Country;
import com.marketing.tool.domain.State;

public interface CountryStateService {
	
	List<State> findByCountryId(Integer countryId);
	List<Country> listAllCountries();

}
