package com.marketing.tool.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;
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
import org.springframework.web.servlet.ModelAndView;

import com.marketing.tool.domain.Country;
import com.marketing.tool.domain.Keyskills;
import com.marketing.tool.domain.Author;
import com.marketing.tool.domain.User;
import com.marketing.tool.exception.UserAlreadyExistsException;
import com.marketing.tool.service.CountryStateService;
import com.marketing.tool.service.KeySkillsService;
import com.marketing.tool.service.LoginUserService;
import com.marketing.tool.service.AuthorService;
import com.marketing.tool.service.UserService;
import com.marketing.tool.utility.Helper;
import com.marketing.tool.validator.CreateFormValidator;

@Controller
public class AuthorController {

	 private static final Logger LOGGER = LoggerFactory.getLogger(AuthorController.class);
	   
	   private final UserService userService;
	 
	 @Autowired
	 private KeySkillsService keySkillsService;
	 
	 @Autowired
		private LoginUserService loginUserService;
	 
	 @Autowired
	 private CreateFormValidator createFormValidator;
	 
	 @Autowired
	 private CountryStateService countryStateService;
	    
	   @Inject
	    public AuthorController(AuthorService authorService) {
	        this.userService = authorService;
	    }
	    	   	    
	    
	   /* public void initBinder(WebDataBinder binder) {
	        binder.addValidators(createFormValidator);
	        //binder.addValidators(integerValidator);
	        //binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
	    }*/
	    
	    @InitBinder("form")
	    protected void initBinder(WebDataBinder binder) {
	       /* binder.registerCustomEditor(Set.class, "keyskills", new CustomCollectionEditor(Set.class) {
	            protected Object convertElement(Object element) {
	                if (element != null) {
	                    Integer id = new Integer((String)element);
	                    Keyskills skill = keySkillsService.findById(id);
	                    return skill;
	                }
	                return null;
	            }
	        });*/
	    	
	    	/*binder.registerCustomEditor(Author.class, "keyskills", new PropertyEditorSupport() {
	    	    @Override
	    	    public void setAsText(String text) {
	    	    	Keyskills ch = keySkillsService.findById(Integer.parseInt(text));
	    	        setValue(ch);
	    	    }
	    	    });*/
	    	binder.addValidators(createFormValidator);
	    	binder.registerCustomEditor(Set.class, "keyskills", new CustomCollectionEditor(Set.class) {
	            protected Object convertElement(Object element) {
	                if (element != null && !"".equals(element)) {
	                    Integer id = new Integer((String)element);
	                    Keyskills skill = keySkillsService.findById(id);
	                    return skill;
	                }
	                return null;
	            }
	        });
	    }
	    
	    
			    
	   
	    /*@Override
	    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception
	    {
	    binder.registerCustomEditor(Integer.class, null, new CustomNumberEditor(Integer.class, true));
	    super.initBinder(request, binder);
	    }
*/
	    @RequestMapping(value = "/public/author_create.html", method = RequestMethod.GET)
	    public ModelAndView getCreateAuthorView(Model model, @Validated Author author, BindingResult result) {
	        LOGGER.debug("Received request for author create view");
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.addObject("form", new Author());
	        initModelList(modelAndView);
	        modelAndView.setViewName("author_create");
   	        return modelAndView;
	    }

	    @RequestMapping(value = "/public/author_create.html", method = RequestMethod.POST)
	    public ModelAndView createAuthor(@ModelAttribute("form") @Valid Author author, BindingResult result) {
	        LOGGER.debug("Received request to create {}, with result={}", author, result);
	        ModelAndView modelAndView = new ModelAndView();
			//modelAndView.addObject("pers", person);
			
			
	        if (result.hasErrors()) {
	        	 //initModelList(model);
	        	initModelList(modelAndView);
	        	modelAndView.setViewName("author_create");
	   	        return modelAndView;
	        }
	        try {
	        	userService.save(author);
	        } catch (UserAlreadyExistsException e) {
	            LOGGER.debug("Tried to create author with existing id", e);
	            result.reject("author.error.exists");
	            modelAndView.setViewName("author_create");
	        }
	        List<User>  authors= userService.getList();
	        modelAndView.addObject("authorUsers", authors);
	        modelAndView.setViewName("author_created");
	        return modelAndView;
	        //return "redirect:/author_created.html";
	    }
	    
	    @RequestMapping(value = { "/secure/home/author.html", "/secure/home/authorhome" }, method = RequestMethod.GET)
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
	        model.addObject("user",user);
	        model.setViewName("authorhome");
	        return model;
	    }
	    
	    private void initModelList(ModelAndView model) {
			List<String> titles = new ArrayList<String>();
			titles.add("MR");
			titles.add("Mrs");
			titles.add("Ms");
			model.addObject("titles", titles);
			
			List<String> accountTypes = new ArrayList<String>();
			accountTypes.add("test");
			accountTypes.add("test1");
			model.addObject("accountTypes", accountTypes);
			
			List<Keyskills> skills = keySkillsService.loadAllKeyskills();
			model.addObject("keyskills" , skills);
			
			List<Country> countries = countryStateService.listAllCountries();
			model.addObject("countryList",countries);
		}
	    
}
