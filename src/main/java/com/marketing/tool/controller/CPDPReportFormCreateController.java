package com.marketing.tool.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.marketing.tool.domain.CPDPReportForm;
import com.marketing.tool.domain.Country;
import com.marketing.tool.domain.MasterIndustries;
import com.marketing.tool.domain.MasterIndustriesView;
import com.marketing.tool.domain.ReportForm;
import com.marketing.tool.exception.UserAlreadyExistsException;
import com.marketing.tool.service.CPDPReportFormService;
import com.marketing.tool.service.CountryStateService;
import com.marketing.tool.service.MasterIndustriesService;
import com.marketing.tool.service.StockExchangeService;
import com.marketing.tool.utility.DateUtills;
import com.marketing.tool.utility.FileUtils;
import com.marketing.tool.utility.SharedConstants;
import com.marketing.tool.utility.StringUtil;
import com.marketing.tool.validator.FileUploadValidator;


@Controller
public class CPDPReportFormCreateController {
		
	 private static final Logger LOGGER = LoggerFactory.getLogger(CPDPReportFormCreateController.class);
	 private static String xlFormats ="xlsx,xlsm,xls";
	   // @Autowired
	    //private CPDPReportFormService cpdpPReportFormService;
	 /*	@Autowired
		 private ReportService reportService;*/
	 	
	 	@Autowired
	    private CPDPReportFormService cpdpPReportFormService;
	 	
	    @Autowired
		 private CountryStateService countryStateService;
	    
	    @Autowired
	    private StockExchangeService stockExchangeService;
	
	    @Autowired
	    private MasterIndustriesService masterIndustriesService;
	    
	    @Autowired
		 private FileUtils fileUtils;
	   	    
	   /* @InitBinder("form")
	    public void initBinder(WebDataBinder binder) {
	    	binder.registerCustomEditor(byte[].class, new ByteArrayMultipartFileEditor());
	    	final SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy");
	    	dateFormat.setLenient(false);
	    	//binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    	binder.registerCustomEditor(Date.class, "publishingDate", new CustomDateEditor(dateFormat, true) {
	    		public void setAsText(String element) throws IllegalArgumentException {
	                if (element != null) {
	                	Date date;
						try {
							date = (Date)dateFormat.parse(element);
							setValue(date);
						} catch (ParseException e) {
							throw new IllegalArgumentException(
									"Could not parse publishingDate : " + element);
						} 
	                    
	                }
	            }
	    	});
	    }
	   */ 
	   
	    @RequestMapping(value = "/publish/cpdpReportForm_create.html", method = RequestMethod.GET)
	    public ModelAndView getCreateReportFormView(Model model, @Validated CPDPReportForm reportForm, BindingResult result) {
	        LOGGER.debug("Received request for reportForm create view");
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.addObject("form", new CPDPReportForm());
	        initModelList(modelAndView);
	        modelAndView.setViewName("cpdpReportForm_create");
   	        return modelAndView;
	    }

	    @RequestMapping(value = "/publish/cpdpReportForm_create.html", method = RequestMethod.POST)
	    public ModelAndView createReportForm(@ModelAttribute("form") @Valid CPDPReportForm reportForm, BindingResult result)  {
	    	System.out.println("published date "+reportForm.getPublishingDate());
	        LOGGER.debug("Received request to create {}, with result={}", reportForm, result);
	        ModelAndView modelAndView = new ModelAndView();
			//modelAndView.addObject("pers", person);
			
			if(reportForm.getReportImg() != null && reportForm.getReportImg().getSize() > 0){
			String ext = reportForm.getReportImg().getOriginalFilename().split("\\.")[1];
			if(reportForm.getComIntl() != null && reportForm.getComIntl().intValue() == 2)
			    FileUploadValidator.validatefile(reportForm,result,xlFormats);
			else if(!((ext.contains("ppt") || ext.contains("docx") || ext.contains("doc"))))
			 FileUploadValidator.validatefile(reportForm,result,"Other");
			}
			else
			{	
				
				//result.addError(new ObjectError("reportImg", "Please Upload Report"));
				//result.reject("reportImg", "File Required");
				result.rejectValue("reportImg", "FileRequired");
			}
			if (result.hasErrors()) {
				 //initModel List(model);
				initModelList(modelAndView);
				modelAndView.setViewName("cpdpReportForm_create");
			    return modelAndView;
			}
	        try {
	        	String filePath = fileUtils.saveFile(reportForm.getReportImg(),StringUtil.buildString(SharedConstants.FILE_PATH+SharedConstants.REEEPORT_FOLDER_PATH));
				//reportComments2.setFilePath(SharedConstants.FILE_PATH+String.valueOf(reportComments2.getReportId()+""+time)+SharedConstants.DOT+reportComments2.getReportFile().getOriginalFilename().split("\\.")[1]);
				//String filePath = StringUtil.buildString(SharedConstants.REEEPORT_FOLDER_PATH,SharedConstants.FILE_SEPERATOR,uuid,time,SharedConstants.DOT,reportForm.getReportImg().getOriginalFilename().split("\\.")[1]);
				//FileUtils.saveFiles(reportForm.getReportImg(),String.valueOf(reportForm.getReportId()),new StringBuilder("E:\\gitImages").append("\\Profile").toString());
				
				reportForm.setFilePath(filePath);
				reportForm.setInsertedDate(DateUtills.getCurrentDate());
				//reportForm.setPublishingDate(DateUtills.getCurrentDate());
				cpdpPReportFormService.save(reportForm);
	        	
	        	} catch (UserAlreadyExistsException e) {
		            LOGGER.error("Tried to create reportForm with existing id", e);
		            result.reject("reportForm.error.exists");
		            modelAndView.setViewName("cpdpReportForm_create");
	        	}catch (IOException e) {
		        	LOGGER.error("Tried to create reportForm with existing id", e);
			        result.reject("reportForm.error.exists");
			        modelAndView.setViewName("cpdpReportForm_create");
	        	} /*catch (ParseException e) {
				LOGGER.error("Date Parsing Exception", e);
		        result.reject("reportForm.error.exists");
		        modelAndView.setViewName("industryReportForm_create");
			}*/ catch (ParseException e) {
					// TODO Auto-generated catch block
				LOGGER.error("Parsing Exception id", e);
		        result.reject("reportForm.error.exists");
		        modelAndView.setViewName("industryReportForm_create");
				}
	        List<ReportForm>  reportForms= cpdpPReportFormService.getAllReports();
	        modelAndView.addObject("reports", reportForms);
	        modelAndView.setViewName("cpdpReportForm_created");
	        return modelAndView;
	        //return "redirect:/reportForm_created.html";
	    }
	    
	    private void initModelList(ModelAndView model) {
			List<String> reportTypes = new ArrayList<String>();
			reportTypes.add("CompanyProfile");
			reportTypes.add("Database");
			model.addObject("reportTypes", reportTypes);
			
			List<Country> countries = countryStateService.listAllCountries();
			model.addObject("countryList",countries);			
			
			//adding stock exchages
			model.addObject("stocksList",stockExchangeService.findAll());
		}
	    
	    public String getJsonElement(List<MasterIndustriesView> bean) {
			String element = null;
			 GsonBuilder gsonbuilder=new GsonBuilder();
	         
	         Gson gson =  gsonbuilder.setExclusionStrategies(new com.google.gson.ExclusionStrategy() {  
	             public boolean shouldSkipField(com.google.gson.FieldAttributes fieldAttributes) {  
	               return "masterIndustries".equals(fieldAttributes.getName())
	            		   || "miChildId".equals(fieldAttributes.getName())
	            		   || "miUpdTs".equals(fieldAttributes.getName()	   
	            				   );  
	             }  
	             public boolean shouldSkipClass(Class<?> arg0) {  
	               return false;  
	             }  
	           }).create();           
	         element =  gson.toJson(bean);
	         return element;
		}
	    
	    @RequestMapping(value = "/public/loadIndustries.json", headers = "Accept=*/*",produces = "application/json", method = RequestMethod.GET)
	    public @ResponseBody
	    String loadIndustries() throws IllegalStateException, IllegalAccessException, InvocationTargetException {
	    	List<MasterIndustries> industries = masterIndustriesService.findAllIndustries();
	    	List<MasterIndustriesView> newBeans = new ArrayList();
	    	for(MasterIndustries indus : industries) {
	    		MasterIndustriesView newbean = new MasterIndustriesView();
	    		BeanUtils.copyProperties(newbean, indus);
	    		newBeans.add(newbean);
	    	}
	        return getJsonElement(newBeans);
	    }

}
