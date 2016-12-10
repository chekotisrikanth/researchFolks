package com.marketing.tool.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;
import org.springframework.web.servlet.ModelAndView;

import com.marketing.tool.domain.IndustryReportForm;
import com.marketing.tool.domain.MasterDataType;
import com.marketing.tool.domain.ReportForm;
import com.marketing.tool.domain.master.Country;
import com.marketing.tool.exception.UserAlreadyExistsException;
import com.marketing.tool.service.CountryStateService;
import com.marketing.tool.service.IndustryReportFormService;
import com.marketing.tool.service.MasterService;
import com.marketing.tool.utility.DateUtills;
import com.marketing.tool.utility.FileUtils;
import com.marketing.tool.utility.SharedConstants;
import com.marketing.tool.utility.StringUtil;
import com.marketing.tool.validator.FileUploadValidator;

@Controller
public class IndustryReportFormCreateController {

	 private static final Logger LOGGER = LoggerFactory.getLogger(IndustryReportFormCreateController.class);
	    
	    @Autowired
	    private IndustryReportFormService industryReportFormService;
		    
	    @Autowired
		 private CountryStateService countryStateService;
	    
	    @Autowired
	    private MasterService masterService;
	    
	    
	   	    
	    @InitBinder("form")
	    public void initBinder(WebDataBinder binder) {
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    	binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    	binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	    }
	    
	    @RequestMapping(value = { "/publish/industryReportForm_create.html"}, method = RequestMethod.GET)
	    public ModelAndView getCreateReportFormView(@RequestParam(required = false) boolean otherForm, @Validated IndustryReportForm reportForm, BindingResult result) {
	        LOGGER.debug("Received request for reportForm create view");
	        ModelAndView modelAndView = new ModelAndView();
	        IndustryReportForm form = new IndustryReportForm();
	        modelAndView.addObject("form", form);
	        form.setComIntl(2);
	        modelAndView.addObject("title","Report Title");
		    modelAndView.addObject("discription","Business Overview");
	        initModelList(modelAndView);
	        modelAndView.setViewName("industryReportForm_create");
   	        return modelAndView;
	    }

	    	    
	    @RequestMapping(value = { "/publish/otherReportForm_create.html"}, method = RequestMethod.GET)
	    public ModelAndView getOtherCreateReportFormView(@RequestParam(required = false) boolean otherForm, @Validated IndustryReportForm reportForm, BindingResult result) {
	        LOGGER.debug("Received request for reportForm create view");
	        ModelAndView modelAndView = new ModelAndView();
	        IndustryReportForm form = new IndustryReportForm();
	        modelAndView.addObject("form", form);
	        form.setComIntl(3);
	        modelAndView.addObject("title","Research Title");
		    modelAndView.addObject("discription","Research Discription");
	        initModelList(modelAndView);
	        modelAndView.setViewName("industryReportForm_create");
   	        return modelAndView;
	    }

	    @RequestMapping(value = "/publish/reportForm_create.html", method = RequestMethod.POST)
	    public ModelAndView createOtherReportForm(@ModelAttribute("form") @Valid IndustryReportForm reportForm, BindingResult result) {
	        LOGGER.debug("Received request to create {}, with result={}", reportForm, result);
	        ModelAndView modelAndView = new ModelAndView();
	        FileUploadValidator.validatefile(reportForm,result);
	        if (result.hasErrors()) {
	        	initModelList(modelAndView);
	        	modelAndView.setViewName("industryReportForm_create");
	   	        return modelAndView;
	        }
	        try {
	        	industryReportFormService.save(reportForm);
	        } catch (IOException | ParseException e) {
	        	 LOGGER.error("Tried to create reportForm with existing id", e);
		          result.reject("reportForm.error.exists");
		          modelAndView.setViewName("industryReportForm_create");
			} 
	        List<ReportForm>  reportForms= industryReportFormService.getAllReports();
	        modelAndView.addObject("reports", reportForms);
	        modelAndView.setViewName("industryReportForm_created");
	        return modelAndView;
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
			model.addObject("updatecycleList",masterService.findByMasterDataType(MasterDataType.UPDATECYCLE));
		}
	    
}
