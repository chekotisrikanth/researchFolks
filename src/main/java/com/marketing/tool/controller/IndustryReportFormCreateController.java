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
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import com.marketing.tool.domain.IndustryReportForm;
import com.marketing.tool.domain.Country;
import com.marketing.tool.domain.ReportForm;
import com.marketing.tool.exception.UserAlreadyExistsException;
import com.marketing.tool.service.IndustryReportFormService;
import com.marketing.tool.service.CountryStateService;

@Controller
public class IndustryReportFormCreateController {

	 private static final Logger LOGGER = LoggerFactory.getLogger(IndustryReportFormCreateController.class);
	    
	    @Autowired
	    private IndustryReportFormService industryReportFormService;
		    
	    @Autowired
		 private CountryStateService countryStateService;
	
	   	    
	    @InitBinder("form")
	    public void initBinder(WebDataBinder binder) {
	        //binder.addValidators(createFormValidator);
	    	//SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    	//dateFormat.setLenient(false);
	    	////binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    	// binder.registerCustomEditor(Date.class, "publishingDate", new CustomDateEditor(dateFormat, true));
	    	/*binder.registerCustomEditor(Date.class, "keyskills", new CustomCollectionEditor(Set.class) {
	            protected Object convertElement(Object element) {
	                if (element != null) {
	                    String date = ((String)element);
	                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	                    java.util.Date date = dateFormat.parse("12/31/2006");
	                    return skill;
	                }
	                return null;
	            }
	        });*/
	    	// Convert multipart object to byte[]
	    	binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	    }
	    
	    
	    
			    
	   
	    /*@Override
	    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception
	    {
	    binder.registerCustomEditor(Integer.class, null, new CustomNumberEditor(Integer.class, true));
	    super.initBinder(request, binder);
	    }
*/
	    @RequestMapping(value = "/publish/industryReportForm_create.html", method = RequestMethod.GET)
	    public ModelAndView getCreateReportFormView(Model model, @Validated IndustryReportForm reportForm, BindingResult result) {
	        LOGGER.debug("Received request for reportForm create view");
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.addObject("form", new IndustryReportForm());
	        initModelList(modelAndView);
	        modelAndView.setViewName("industryReportForm_create");
   	        return modelAndView;
	    }

	    @RequestMapping(value = "/publish/industryReportForm_create.html", method = RequestMethod.POST)
	    public ModelAndView createReportForm(@ModelAttribute("form") @Valid IndustryReportForm reportForm, BindingResult result) {
	        LOGGER.debug("Received request to create {}, with result={}", reportForm, result);
	        ModelAndView modelAndView = new ModelAndView();
			//modelAndView.addObject("pers", person);
			
			
	        if (result.hasErrors()) {
	        	 //initModelList(model);
	        	initModelList(modelAndView);
	        	modelAndView.setViewName("industryReportForm_create");
	   	        return modelAndView;
	        }
	        try {
	        	industryReportFormService.save(reportForm);
	        } catch (UserAlreadyExistsException e) {
	            LOGGER.debug("Tried to create reportForm with existing id", e);
	            result.reject("reportForm.error.exists");
	            modelAndView.setViewName("industryReportForm_create");
	        }
	        List<ReportForm>  reportForms= industryReportFormService.getAllReports();
	        modelAndView.addObject("reports", reportForms);
	        modelAndView.setViewName("industryReportForm_created");
	        return modelAndView;
	        //return "redirect:/reportForm_created.html";
	    }
	    
	    private void initModelList(ModelAndView model) {
			List<String> companyType = new ArrayList<String>();
			companyType.add("Public");
			companyType.add("Private");
			model.addObject("companyTypeList", companyType);
			
			List<String> stockExchange = new ArrayList<String>();
			stockExchange.add("NSE");
			stockExchange.add("BSE");
			model.addObject("stockExchangeList", stockExchange);
			
			List<Country> countries = countryStateService.listAllCountries();
			model.addObject("countryList",countries);
		}
	    
}
