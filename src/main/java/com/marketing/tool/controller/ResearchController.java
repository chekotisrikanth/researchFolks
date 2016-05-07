package com.marketing.tool.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.marketing.tool.domain.EditReports;
import com.marketing.tool.service.LoginUserService;
import com.marketing.tool.service.MasterIndustriesService;
import com.marketing.tool.service.PublishedReportsService;
import com.marketing.tool.service.ReportService;
import com.marketing.tool.service.ResearchReportsService;
import com.marketing.tool.vo.SearchCriteria;

/**
 * @author Anilkumar Ravula
 *
 */
@Controller
public class ResearchController {

	 private static final Logger LOGGER = LoggerFactory.getLogger(ResearchController.class);
	   
	 
	 	@Autowired
		private LoginUserService loginUserService;
	 	
	 	@Autowired
	    private ReportService reportFormService;
	 	@Autowired
	 	private ResearchReportsService researchReportsService;
	 	@Autowired
	 	private PublishedReportsService publishedReportsService;
	 	
	 	@Autowired
	 	private MasterIndustriesService masterIndustriesService;
	 	
	 	@RequestMapping(value = "/freefolk/getPublishedReports/{pageNumber}/{noOfPages}", method = RequestMethod.POST)
	    public @ResponseBody EditReports loginSuccessPage(@RequestBody SearchCriteria criteria,@PathVariable Integer pageNumber,@PathVariable Integer noOfPages,@RequestParam(value = "error",required = false) String error,
	    @RequestParam(value = "logout", required = false) String logout, Model model1) {
	        
	        //User user = loginUserService.findByEmailId(Helper.getPrincipal()); 
	      
	        return researchReportsService.getPublishedReportsFromSearchCriteria(criteria,pageNumber,noOfPages);
	    }
	 	
	 	
	 	@RequestMapping(value = "/freefolk/getPublishedReports", method = RequestMethod.GET)
	    public ModelAndView publishedReports( Model model1) {
	         
	        ModelAndView model = new ModelAndView();
	        
	        model.addObject("totalCount",publishedReportsService.getTotalPublishedRecordsCount());
	        model.addObject("industries",masterIndustriesService.findAllIndustries());
	        model.setViewName("researchStore");
	        return model;
	    }
	    
	    
}
