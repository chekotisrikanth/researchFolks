package com.marketing.tool.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketing.tool.domain.Admin;
import com.marketing.tool.domain.EditReports;
import com.marketing.tool.domain.ReportForm;
import com.marketing.tool.domain.User;
import com.marketing.tool.domain.UserProfileType;
import com.marketing.tool.domain.ViewReports;
import com.marketing.tool.exception.UserAlreadyExistsException;
import com.marketing.tool.service.AdminService;
import com.marketing.tool.service.LoginUserService;
import com.marketing.tool.service.ReportService;
import com.marketing.tool.utility.Helper;
import com.marketing.tool.validator.CreateFormValidator;

@Controller
public class AdminController {

	 private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
	    
	 ObjectMapper mapper = new ObjectMapper();
	  
	    @Autowired
	    private AdminService adminService;
	    
	    @Autowired
	    private CreateFormValidator createFormValidator;
	    
	    @Autowired
		private LoginUserService loginUserService;
	    
	    @Autowired
	    private ReportService reportFormService;
	    
	         
	    @InitBinder("form")
	    public void initBinder(WebDataBinder binder) {
	        binder.addValidators(createFormValidator);
	        //binder.addValidators(integerValidator);
	        //binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
	    }
	    
	    
	    
			    
	   
	    /*@Override
	    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception
	    {
	    binder.registerCustomEditor(Integer.class, null, new CustomNumberEditor(Integer.class, true));
	    super.initBinder(request, binder);
	    }
*/
	    @RequestMapping(value = "/public/admin_create.html", method = RequestMethod.GET)
	    public ModelAndView getCreateAdminView(Model model, @Validated Admin admin, BindingResult result) {
	        LOGGER.debug("Received request for admin create view");
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.addObject("form", new Admin());
	        initModelList(modelAndView);
	        modelAndView.setViewName("admin_create");
   	        return modelAndView;
	    }
	    @Secured("ROLE_ADMIN")
	    @RequestMapping(value = "/public/admin_create.html", method = RequestMethod.POST)
	    public ModelAndView createAdmin(@ModelAttribute("form") @Valid Admin admin, BindingResult result) {
	        LOGGER.debug("Received request to create {}, with result={}", admin, result);
	        ModelAndView modelAndView = new ModelAndView();
			//modelAndView.addObject("pers", person);
			
			
	        if (result.hasErrors()) {
	        	 //initModelList(model);
	        	initModelList(modelAndView);
	        	modelAndView.setViewName("admin_create");
	   	        return modelAndView;
	        }
	        try {
	        	adminService.save(admin);
	        } catch (UserAlreadyExistsException e) {
	            LOGGER.debug("Tried to create admin with existing id", e);
	            result.reject("admin.error.exists");
	            modelAndView.setViewName("admin_create");
	        }
	        List<User>  admins= adminService.getList();
	        modelAndView.addObject("adminUsers", admins);
	        modelAndView.setViewName("admin_created");
	        return modelAndView;
	    }
	    @Secured("ROLE_ADMIN")
	    @RequestMapping(value = { "/secure/home/admin.html", "/secure/home/admin" }, method = RequestMethod.GET)
	    public ModelAndView loginSuccessPage(@RequestParam(value = "error",required = false) String error,
	    @RequestParam(value = "logout", required = false) String logout) {
	         
	        ModelAndView model = new ModelAndView();
	        initModelList(model);
	        if (error != null) {
	            model.addObject("error", "Invalid Credentials provided.");
	        }
	 
	        if (logout != null) {
	            model.addObject("message", "Logged out from JournalDEV successfully.");
	        }
	        User user = loginUserService.findByEmailId(Helper.getPrincipal()); 
	        List<ReportForm> reports = reportFormService.getAllReports();
	        EditReports editreports = new EditReports();
	        editreports.setReports(reports);
	        List<User> reviewers = loginUserService.findByAccountType(UserProfileType.REVIEWER.toString());
	        List<User> publishers = loginUserService.findByAccountType(UserProfileType.PUBLISHER.toString());
	        
	        String reviewersJson = "";
	        String publishersJson = "";
			try {
				reviewersJson = mapper.writeValueAsString(reviewers);
				publishersJson = mapper.writeValueAsString(publishers);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
	        model.addObject("user",user);
	        model.addObject("reviewersJson",reviewers);
	        model.addObject("publishersJson",publishers);
	        model.addObject("editreports",editreports);
	        model.addObject("viewreports",new ViewReports());
	        model.setViewName("adminhome");
	        return model;
	    }
	   
	    private void initModelList(ModelAndView model) {
			List<String> titles = new ArrayList<String>();
			titles.add("MR");
			titles.add("Mrs");
			titles.add("Ms");
			model.addObject("titles", titles);
			
			List<UserProfileType> accountTypes = Arrays.asList(UserProfileType.values());
			//accountTypes.add(UserProfileType.ADMIN.toString());
			//accountTypes.add(UserProfileType.REVIEWER.toString());
			//accountTypes.add(UserProfileType.PUBLISHER.toString());
			model.addObject("accountTypes", accountTypes);
		}
	    @Secured("ROLE_ADMIN")
	    @RequestMapping(value = "/secure/home/admin/{pageNumber}/{noOfPages}", method = RequestMethod.GET)
	    public ModelAndView getReportsForAdmin(@PathVariable Integer pageNumber,@PathVariable Integer noOfPages, @RequestParam(value = "error",required = false) String error,
	    @RequestParam(value = "logout", required = false) String logout, Model model1) {
	         
	        ModelAndView model = new ModelAndView();
	        initModelList(model);
	        if (error != null) {
	            model.addObject("error", "Invalid Credentials provided.");
	        }
	 
	        if (logout != null) {
	            model.addObject("message", "Logged out from JournalDEV successfully.");
	        }
	        User user = loginUserService.findByEmailId(Helper.getPrincipal()); 
	        EditReports editreports = reportFormService.getAllReports(pageNumber,noOfPages);
	       /* EditReports editreports = new EditReports();
	        editreports.setReports(reports);*/
	        List<User> reviewers = loginUserService.findByAccountType(UserProfileType.REVIEWER.toString());
	        List<User> publishers = loginUserService.findByAccountType(UserProfileType.PUBLISHER.toString());
	        
	      /*  String reviewersJson = "";
	        String publishersJson = "";
			try {
				reviewersJson = mapper.writeValueAsString(reviewers);
				publishersJson = mapper.writeValueAsString(publishers);
			} catch (Exception e) {
				e.printStackTrace();
			}*/
			
	        model.addObject("user",user);
	        model.addObject("reviewersJson",reviewers);
	        model.addObject("publishersJson",publishers);
	        model.addObject("editreports",editreports);
	        model.addObject("viewreports",new ViewReports());
	        model.setViewName("adminhome");
	        return model;
	    }
}
