package com.marketing.tool.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.marketing.tool.domain.Author;
import com.marketing.tool.domain.Country;
import com.marketing.tool.domain.Customer;
import com.marketing.tool.domain.CustomerAuthorFavList;
import com.marketing.tool.domain.CustomerAuthorFavListId;
import com.marketing.tool.domain.Keyskills;
import com.marketing.tool.domain.PurchaseOrder;
import com.marketing.tool.domain.User;
import com.marketing.tool.exception.UserAlreadyExistsException;
import com.marketing.tool.service.CountryStateService;
import com.marketing.tool.service.CustomerService;
import com.marketing.tool.service.KeySkillsService;
import com.marketing.tool.service.LoginUserService;
import com.marketing.tool.service.UserService;
import com.marketing.tool.utility.Helper;
import com.marketing.tool.validator.CreateFormValidator;

@Controller
public class CustomerCreateController {

	 private static final Logger LOGGER = LoggerFactory.getLogger(CustomerCreateController.class);
	    private final UserService userService;
	    private final CreateFormValidator createFormValidator;
	    
	    @Autowired
		KeySkillsService skills;
	    
	    @Autowired
		CountryStateService countryService;
	    
	    @Autowired
		 private CountryStateService countryStateService;
	    
	    @Autowired
		private LoginUserService loginUserService;
	    
	    @Autowired
	    private CustomerService customerService;
	    
	    @Inject
	    public CustomerCreateController(CustomerService customerService, CreateFormValidator createFormValidator) {
	        this.userService = customerService;
	        this.createFormValidator = createFormValidator;
	    }

	   	    
	    @InitBinder("form")
	    public void initBinder(WebDataBinder binder) {
	        binder.addValidators(createFormValidator);
	    }
	    

	    @RequestMapping(value = "/public/customer_create.html", method = RequestMethod.GET)
	    public ModelAndView getCreateCustomerView(Model model, @Validated Customer customer, BindingResult result) {
	        LOGGER.debug("Received request for customer create view");
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.addObject("form", new Customer());
	        initModelList(modelAndView);
	        modelAndView.setViewName("customer_create");
   	        return modelAndView;
	    }

	    @RequestMapping(value = "/public/customer_create.html", method = RequestMethod.POST)
	    public ModelAndView createCustomer(@ModelAttribute("form") @Valid Customer customer, BindingResult result) {
	        LOGGER.debug("Received request to create {}, with result={}", customer, result);
	        ModelAndView modelAndView = new ModelAndView();
			//modelAndView.addObject("pers", person);
			
			
	        if (result.hasErrors()) {
	        	 //initModelList(model);
	        	initModelList(modelAndView);
	        	modelAndView.setViewName("customer_create");
	   	        return modelAndView;
	        }
	        try {
	        	userService.save(customer);
	        } catch (UserAlreadyExistsException e) {
	            LOGGER.debug("Tried to create customer with existing id", e);
	            result.reject("customer.error.exists");
	            modelAndView.setViewName("customer_create");
	        }
	        List<User>  customers= userService.getList();
	        modelAndView.addObject("customerUsers", customers);
	        modelAndView.setViewName("customer_created");
	        return modelAndView;
	        //return "redirect:/customer_created.html";
	    }
	    
	    private void initModelList(ModelAndView model) {
			List<String> titles = new ArrayList<String>();
			titles.add("MR");
			titles.add("Mrs");
			titles.add("Ms");
			model.addObject("titles", titles);
			
			
			List<String> occupationList = new ArrayList<String>();
			occupationList.add("Occupation-1");
			occupationList.add("Occupation-2");
			occupationList.add("Occupation-3");
			model.addObject("occupationList", occupationList);
			
			List<String> accountTypes = new ArrayList<String>();
			accountTypes.add("test");
			accountTypes.add("test1");
			model.addObject("accountTypes", accountTypes);
			
			List<Country> countries = countryStateService.listAllCountries();
			model.addObject("countryList",countries);
		}
	  
	    @RequestMapping(value = { "/secure/home/customer.html", "/secure/home/customerhome" }, method = RequestMethod.GET)
	    public ModelAndView loginSuccessPage(@RequestParam(value = "error",required = false) String error,
	    @RequestParam(value = "logout", required = false) String logout) {
	         
	        ModelAndView model = new ModelAndView();
	        if (error != null) {
	            model.addObject("error", "Invalid Credentials provided.");
	        }
	 
	        if (logout != null) {
	            model.addObject("message", "Logged out from JournalDEV successfully.");
	        }
	        User user = loginUserService.findByEmailId(Helper.getPrincipal()); 
	        
	        if(user==null) {
	        	model.setViewName("loginPage");
	        	return model;
	        }
	        
	        List<PurchaseOrder> purchases = user.getOrders();
	        model.addObject("customer",user);
	        model.addObject("purchases",purchases);
	        model.setViewName("customerhome");
	        return model;
	    }
	    
	    
	    
	    @RequestMapping(value = "/secure/customer/authorshortlist", method = RequestMethod.POST)
	    public @ResponseBody String shortListAuthor(@RequestParam(value = "reportId",required = true) Integer reportId,
	    		@RequestParam(value = "custmerId",required = true) Integer custmerId,
	    		@RequestParam(value = "authorId",required = true) Integer authorId) {
	    	CustomerAuthorFavListId customerAuthorFavListId = new CustomerAuthorFavListId(authorId,custmerId,reportId);
	    	CustomerAuthorFavList favlist = customerService.loadFavList(customerAuthorFavListId);
	    	if(favlist==null) {
	    		favlist = new CustomerAuthorFavList(customerAuthorFavListId,true);
	    	}else {
	    		favlist.setFavourite(true);
	    	}
	    	customerService.saveFavList(favlist);
	    	return "success";
	    }
	    
	    @RequestMapping(value = "/secure/customer/rateauthor", method = RequestMethod.POST)
	    public @ResponseBody String rateAuthor(@RequestParam(value = "reportId",required = true) Integer reportId,
	    		@RequestParam(value = "custmerId",required = true) Integer custmerId,
	    		@RequestParam(value = "authorId",required = true) Integer authorId,
	    		@RequestParam(value = "rating",required = true) Integer rating) {
	    	CustomerAuthorFavListId customerAuthorFavListId = new CustomerAuthorFavListId(authorId,custmerId,reportId);
	    	CustomerAuthorFavList favlist = customerService.loadFavList(customerAuthorFavListId);
	    	if(favlist==null) {
	    		favlist = new CustomerAuthorFavList(customerAuthorFavListId,false,rating);
	    	}else {
	    		favlist.setRating(rating);
	    	}
	    	customerService.saveFavList(favlist);
	    	return "success";
	    }
	    
	    @RequestMapping(value = "/secure/customer/customerreview", method = RequestMethod.GET)
	    public ModelAndView customerreviewlandingpage(@RequestParam(value = "reportId",required = true) Integer reportId,
	    		@RequestParam(value = "customerId",required = true) Integer custmerId,
	    		@RequestParam(value = "authorId",required = true) Integer authorId) {
	    	CustomerAuthorFavListId customerAuthorFavListId = new CustomerAuthorFavListId(authorId,custmerId,reportId);
	    	CustomerAuthorFavList favlist = new CustomerAuthorFavList(customerAuthorFavListId);
	    	ModelAndView view = new ModelAndView();
	    	view.addObject("favlist",favlist);
	    	view.setViewName("customerauthorreview");
	    	return view;
	    }
	    
	    @RequestMapping(value = "/secure/customer/customerreview", method = RequestMethod.POST)
	    public @ResponseBody String customerreview(@ModelAttribute("favlist") @Valid CustomerAuthorFavList favlist, BindingResult result) {
	    	CustomerAuthorFavList existingfavlist = customerService.loadFavList(favlist.getId());
	    	if(existingfavlist!=null) {
	    		existingfavlist.setReview(favlist.getReview());
	    	}else {
	    		existingfavlist = favlist;
	    	}
	    	customerService.saveFavList(existingfavlist);
	    	return "success";
	    }
	    
	    @RequestMapping(value = { "/secure/customer/loadFavList"}, method = RequestMethod.POST)
	    public ModelAndView loadFavList(@RequestParam(value = "customerId",required = true) Integer customerId) {
	    	User customer = loginUserService.findById(customerId);
	    	List<CustomerAuthorFavList> favAnalyst = customerService.loadFavAnalyst((Customer) customer);
	    	Map<Integer,Author> filterFavAnalyst = new HashMap<Integer,Author>();
	    	
	    	for(CustomerAuthorFavList analyst: favAnalyst) {
	    		filterFavAnalyst.put(analyst.getAuthor().getId(), analyst.getAuthor());
	    	}
	    	List<Keyskills> skillList = skills.loadAllKeyskills();
			List<Country> countries= countryService.listAllCountries();
	    	ModelAndView modelAndView = new ModelAndView();
	    	modelAndView.addObject("favAnalyst", filterFavAnalyst.values());
	    	modelAndView.addObject("skills", skillList);
	    	modelAndView.addObject("countries", countries);
	    	modelAndView.setViewName("customerFavAnalyst");
	    	return modelAndView;
	    }
	    
	    @RequestMapping(value = {"/public/author/bio" }, method = {RequestMethod.GET})
	    public ModelAndView getAuthorBio(@RequestParam(value="authorId",required = true) Integer authorId) {
	        User user = loginUserService.findById(authorId); 	
	        ModelAndView view= new ModelAndView();
	        view.setViewName("userbio");
	        view.addObject("author",user);
	        return view;
	    }
	    
}
