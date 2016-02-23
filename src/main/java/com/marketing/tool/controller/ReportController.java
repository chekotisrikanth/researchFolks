package com.marketing.tool.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketing.tool.domain.ViewReports;
import com.marketing.tool.service.AdminService;
import com.marketing.tool.service.LoginUserService;
import com.marketing.tool.service.ReportService;
import com.marketing.tool.validator.CreateFormValidator;

@Controller
public class ReportController {

	 private static final Logger LOGGER = LoggerFactory.getLogger(ReportController.class);
	    
	 ObjectMapper mapper = new ObjectMapper();
	  
	    @Autowired
	    private AdminService adminService;
	    
	    @Autowired
	    private CreateFormValidator createFormValidator;
	    
	    @Autowired
		private LoginUserService loginUserService;
	    
	    @Autowired
	    private ReportService reportFormService;
	    
	         
	    @RequestMapping(value = "/secure/updateReports.html", method = RequestMethod.POST)
	    public String updateReports(@ModelAttribute("editreports") @Valid ViewReports viewReports, BindingResult result) {
	        reportFormService.updateReports(viewReports);
	        return "redirect:/secure/home/admin";
	    }
	    
}
