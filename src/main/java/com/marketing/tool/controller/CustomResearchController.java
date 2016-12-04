package com.marketing.tool.controller;



import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.marketing.tool.domain.Author;
import com.marketing.tool.domain.CustomResearch;
import com.marketing.tool.domain.MasterDataType;
import com.marketing.tool.domain.master.Country;
import com.marketing.tool.domain.master.Keyskills;
import com.marketing.tool.exception.UserAlreadyExistsException;
import com.marketing.tool.service.AuthorService;
import com.marketing.tool.service.CountryStateService;
import com.marketing.tool.service.CustomResearchService;
import com.marketing.tool.service.KeySkillsService;
import com.marketing.tool.service.MasterService;

@Controller
public class CustomResearchController {

	@Autowired
	CustomResearchService customResearchService;
	
	@Autowired
	KeySkillsService skills;
	
	@Autowired
	CountryStateService countryService;
	
	@Autowired
	AuthorService authorService;
	
	@Autowired
	KeySkillsService keySkillsService;
	
	 @Autowired
	    private MasterService masterService;
	 
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomResearchController.class);
	
	
	
	@RequestMapping(value = "/public/customresearch", method = RequestMethod.GET)
	public ModelAndView view(Model model,@RequestParam(value="authorId",required = false) Integer authorId) {
		ModelAndView modelAndView = new ModelAndView();
		CustomResearch customResearch = new CustomResearch();
		customResearch.setAnalyst(String.valueOf(authorId));
        modelAndView.addObject("form",customResearch );
        initModelList(modelAndView,authorId);
        modelAndView.setViewName("customResearch");
        return modelAndView;
	}
	
	@RequestMapping(value = "/public/customresearch", method = RequestMethod.POST)
	public ModelAndView submit(@ModelAttribute("form") @Valid CustomResearch customResearch,BindingResult result,@RequestParam(value="authorId",required = false) Integer authorId) {
		LOGGER.debug("Received request to create {}, with result={}", customResearch, result);
        ModelAndView modelAndView = new ModelAndView("customResearch", result.getModel());//new ModelAndView();
		
        if (result.hasErrors()) {
        	initModelList(modelAndView,authorId);
        	modelAndView.setViewName("customResearch");
   	        return modelAndView;
        }
        try {
        	customResearchService.save(customResearch);
        } catch (UserAlreadyExistsException e) {
            LOGGER.debug("Tried to create author with existing id", e);
            result.reject("author.error.exists");
            modelAndView.setViewName("customResearch");
        }
        //modelAndView.addObject("authorUsers", authors);
        modelAndView.setViewName("customeResearch_created");
        return modelAndView;
	}
	
	@RequestMapping(value="/public/loadauthors",method=RequestMethod.GET)
	public ModelAndView loadAuthors(@RequestParam(value = "country",required = false) String country,
		    @RequestParam(value = "skills", required = true) String skillIds) {
		ModelAndView view = new ModelAndView();
		List<Keyskills> skillList = new ArrayList<Keyskills>();
		String[] skills = skillIds.split(",");
		for(String skill : skills) {
			Integer skillId = new Integer(skill);
			Keyskills keyskill = keySkillsService.findById(skillId);
			skillList.add(keyskill);
		}
		List<Author> authorsList = authorService.findAuhtors(country, skillList);
		view.addObject("authorsList", authorsList);
		view.setViewName("customResearchAuthorTable");
		return view;
	}
	
	private void initModelList(ModelAndView modelAndView,Integer authorId) {
		Author author=null;
		List<Keyskills> skillList = skills.loadAllKeyskills();
		List<Country> countries= countryService.listAllCountries();
		if(authorId!=null) {
			author = authorService.findById(authorId);
		}
		author = authorService.findById(authorId);
		modelAndView.addObject("skills", skillList);
		modelAndView.addObject("countries", countries);
		modelAndView.addObject("reqauthor",author);
		modelAndView.addObject("turnaroundtimeList",masterService.findByMasterDataType(MasterDataType.TURNAROUNDTIME));
		modelAndView.addObject("researchTypeList",masterService.findByMasterDataType(MasterDataType.RESEARCHTYPE));
	}
}