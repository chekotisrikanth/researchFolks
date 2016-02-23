package com.marketing.tool.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.marketing.tool.domain.State;
import com.marketing.tool.service.CountryStateService;


@Controller
public class CountryStateController {

	 @Autowired
	    private CountryStateService countryStateServiceImpl;
	    private ModelAndView mav;

	    
	    @RequestMapping(value = "/countrystate.html", method = RequestMethod.GET)
	    public ModelAndView loadCountries() {

	        mav = new ModelAndView();
	        mav.addObject("countryList", countryStateServiceImpl.listAllCountries());
	        mav.setViewName("countrystate");
	        return mav;
	    }

	    @RequestMapping(value = "/public/loadStates.json", headers = "Accept=*/*",produces = "application/json", method = RequestMethod.GET)
	    public @ResponseBody
	    List<State> loadStates(@RequestParam(value = "countryId", required = true) Integer countryId) throws IllegalStateException {

	        //Specify the returning object you want here
	    	List<State> statesForCountry = countryStateServiceImpl.findByCountryId(countryId);
	        return statesForCountry;
	    }
}
