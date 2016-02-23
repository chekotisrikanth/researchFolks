package com.marketing.tool.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.marketing.tool.domain.User;
import com.marketing.tool.service.LoginUserService;
import com.marketing.tool.utility.Helper;

@Controller
public class ReviewerController {

	 private static final Logger LOGGER = LoggerFactory.getLogger(ReviewerController.class);
	   
	 
	 @Autowired
		private LoginUserService loginUserService;
	 
	    @RequestMapping(value = { "/secure/home/reviewer.html", "/secure/home/reviewer" }, method = RequestMethod.GET)
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
	        model.addObject("user",user);
	        model.setViewName("reviewerhome");
	        return model;
	    }
	    
	    
}
