package com.marketing.tool.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.marketing.tool.domain.EditReports;
import com.marketing.tool.domain.User;
import com.marketing.tool.service.LoginUserService;
import com.marketing.tool.service.ReportService;
import com.marketing.tool.utility.Helper;

@Controller
public class PublisherController {

	 private static final Logger LOGGER = LoggerFactory.getLogger(PublisherController.class);
	   
	 
	 	@Autowired
		private LoginUserService loginUserService;
	 	
	 	@Autowired
	    private ReportService reportFormService;
	 
	    /*@RequestMapping(value = { "/secure/home/publisher.html", "/secure/home/publisher" }, method = RequestMethod.GET)
	    public ModelAndView loginSuccessPage(@RequestParam(value = "error",required = false) String error,
	    @RequestParam(value = "logout", required = false) String logout) {
	         
	        ModelAndView model = new ModelAndView();
	        if (error != null) {
	            model.addObject("error", "Invalid Credentials provided.");
	        }
	 
	        if (logout != null) {
	            model.addObject("message", "Logged out successfully.");
	        }
	        User user = loginUserService.findByEmailId(Helper.getPrincipal()); 
	        //Get Reporter assigned reportes
	        EditReports editreports = new EditReports();
	        editreports.setReports(reportFormService.getPublisherReports(user.getId()));
	        model.addObject("user",user);
	        model.addObject("editreports",editreports);
	        model.setViewName("publisherhome");
	        return model;
	    }*/
	 	
	 	@RequestMapping(value = "/secure/home/publisher/{pageNumber}/{noOfPages}", method = RequestMethod.GET)
	    public ModelAndView loginSuccessPage(@PathVariable Integer pageNumber,@PathVariable Integer noOfPages,@RequestParam(value = "error",required = false) String error,
	    @RequestParam(value = "logout", required = false) String logout, Model model1) {
	         
	        ModelAndView model = new ModelAndView();
	        if (error != null) {
	            model.addObject("error", "Invalid Credentials provided.");
	        }
	 
	        if (logout != null) {
	            model.addObject("message", "Logged out successfully.");
	        }
	        User user = loginUserService.findByEmailId(Helper.getPrincipal()); 
	        //Get Reporter assigned reportes
	        /*EditReports editreports = new EditReports();
	        editreports.setReports(reportFormService.getPublisherReports(user.getId()));*/
	        model.addObject("user",user);
	        model.addObject("editreports",reportFormService.getPublisherReports(user.getId(),pageNumber,noOfPages));
	        model.setViewName("publisherhome");
	        return model;
	    }
	    
	    
}
