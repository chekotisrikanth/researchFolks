package com.marketing.tool.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketing.tool.domain.ReportAssigners;
import com.marketing.tool.domain.ReportCommentsVo;
import com.marketing.tool.domain.UserProfileType;
import com.marketing.tool.service.ReportService;
import com.marketing.tool.utility.Helper;
import com.marketing.tool.utility.SharedConstants;
import com.marketing.tool.validator.CreateFormValidator;
import com.marketing.tool.vo.BasicResp;

@Controller
public class ReportAssignController {

	 private static final Logger LOGGER = LoggerFactory.getLogger(ReportAssignController.class);
	    
	 ObjectMapper mapper = new ObjectMapper();
	 
	    
	    @Autowired
	    private CreateFormValidator createFormValidator;
	    @Autowired
	    private  ReportService reportServiceImpl;
	    
	
	  
	    
	         
	    @InitBinder("form")
	    public void initBinder(WebDataBinder binder) {
	        binder.addValidators(createFormValidator);
	        //binder.addValidators(integerValidator);
	        //binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, false));
	    }  
	
	    @RequestMapping(value = "admin/asignReports", method = RequestMethod.POST)
	    public @ResponseBody BasicResp assignReports (Model model,@RequestBody  @Validated List<ReportAssigners> assginers, BindingResult result) {
	    	
	    	LOGGER.debug("assignReports entry {}",assginers);
	    	
	    	BasicResp resp = new BasicResp();
	    	
	    	try {
	    		//assign reports
	    		reportServiceImpl.assignReports(assginers);	    		 
	    		resp.setRespCode(0000);
	    		resp.setMessage(SharedConstants.SUCCESS);
	    	}catch(Exception e) {
	    		LOGGER.error("exception raised  cause: {} :stack trace: {}",e.getCause(),e);
	    	}
	    	
	    	
	    	LOGGER.debug("assignReports exit");
   	        return resp;
	    }    
	    @RequestMapping(value = "reviwer/asignReports", method = RequestMethod.POST)
	    public @ResponseBody BasicResp reportsCommnts (@ModelAttribute  @Validated ReportCommentsVo reports, BindingResult result) {
	    	
	    	LOGGER.debug("assignReports entry {}",reports);
	    	
	    	BasicResp resp = null;
	    	
	    	try {
	    		//User user = loginUserService.findByEmailId(Helper.getPrincipal());
	    		 //validate and get userId from Assignment
	    		String emailId = Helper.getPrincipal();
	    		reports.setEmailId(emailId);
	    		reports.setRole(Helper.getRole());
	    		resp=reportServiceImpl.saveReportComments(reports);
	    		
	    		//	 				FileUtils.saveFiles(reportForm.getReportImg(),String.valueOf(reportForm.getReportId()),new StringBuilder("E:\\gitImages").append("\\Profile").toString());

	    		//reportServiceImpl.assignReports(assginers);	
	    		//resp.setRespCode(0000);
	    		//resp.setMessage("Success");
	    	}catch(Exception e) {
	    		LOGGER.error("exception raised  cause: {} :stack trace: {}",e.getCause(),e);
	    	}
	    	
	    	
	    	LOGGER.debug("assignReports exit");
   	        return resp;
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
	    
	    
	    @RequestMapping(value = "/publisher/asignReports", method = RequestMethod.POST)
	    public @ResponseBody BasicResp publishReports (Model model,@RequestBody   List<Integer> assginers, BindingResult result) {
	    	
	    	LOGGER.debug("assignReports entry {}",assginers);
	    	
	    	BasicResp resp = new BasicResp();
	    	if(CollectionUtils.isEmpty(assginers)) {
	    		resp.setRespCode(0010);
	    		resp.setMessage("Please Selecte Atleast One Report");
	    	}
	    	
	    	try {
	    		String emailId = Helper.getPrincipal();
	    		//assign reports
	    		reportServiceImpl.publishReports(assginers, emailId);	
	    		 
	    		resp.setRespCode(0000);
	    		resp.setMessage(SharedConstants.SUCCESS);
	    	}catch(Exception e) {
	    		LOGGER.error("exception raised  cause: {} :stack trace: {}",e.getCause(),e);
	    	}
	    	
	    	
	    	LOGGER.debug("assignReports exit");
   	        return resp;
	    }  
	    
}
