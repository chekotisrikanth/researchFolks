package com.marketing.tool.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

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
import com.marketing.tool.utility.DateUtills;
import com.marketing.tool.utility.FileUtils;
import com.marketing.tool.utility.SharedConstants;
import com.marketing.tool.utility.StringUtil;
import com.marketing.tool.validator.FileUploadValidator;
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
			
	        if(reportForm.getReportImg() != null && reportForm.getReportImg().getSize() > 0){
				String ext = reportForm.getReportImg().getOriginalFilename().split("\\.")[1];
				if(reportForm.getComIntl() != null && reportForm.getComIntl().equals(4))
				    FileUploadValidator.validatefile(reportForm,result,".excel");
				else if(!(ext.contains("ppt") || ext.contains("docx") || ext.contains("doc")))
				 FileUploadValidator.validatefile(reportForm,result,"Other");
				}
				else
				{	
					
					//result.addError(new ObjectError("reportImg", "Please Upload Report"));
					//result.reject("reportImg", "File Required");
					result.rejectValue("reportImg", "FileRequired");
				}
			
	        if (result.hasErrors()) {
	        	 //initModelList(model);
	        	initModelList(modelAndView);
	        	modelAndView.setViewName("industryReportForm_create");
	   	        return modelAndView;
	        }
	        try {
	        	long time= Calendar.getInstance().getTimeInMillis();
	        	 String uuid = UUID.randomUUID().toString();
				 FileUtils.saveFiles(reportForm.getReportImg(),String.valueOf(uuid+""+time),StringUtil.buildString(SharedConstants.FILE_PATH+SharedConstants.REEEPORT_FOLDER_PATH));
					//reportComments2.setFilePath(SharedConstants.FILE_PATH+String.valueOf(reportComments2.getReportId()+""+time)+SharedConstants.DOT+reportComments2.getReportFile().getOriginalFilename().split("\\.")[1]);
	        	String filePath = StringUtil.buildString(SharedConstants.REEEPORT_FOLDER_PATH,SharedConstants.FILE_SEPERATOR,uuid,time,SharedConstants.DOT,reportForm.getReportImg().getOriginalFilename().split("\\.")[1]);
				//FileUtils.saveFiles(reportForm.getReportImg(),String.valueOf(reportForm.getReportId()),new StringBuilder("E:\\gitImages").append("\\Profile").toString());
	        	reportForm.setInsertedDate(DateUtills.getCurrentDate());
	        	//reportForm.setPublishingDate(DateUtills.getCurrentDate());
	        	reportForm.setFilePath(filePath);
	        	industryReportFormService.save(reportForm);
	        } catch (UserAlreadyExistsException e) {
	            LOGGER.error("Tried to create reportForm with existing id", e);
	            result.reject("reportForm.error.exists");
	            modelAndView.setViewName("industryReportForm_create");
	        }catch (IOException e) {
	        	 LOGGER.error("Tried to create reportForm with existing id", e);
		          result.reject("reportForm.error.exists");
		          modelAndView.setViewName("industryReportForm_create");
			} catch (ParseException e) {
				LOGGER.error("Date Parsing Exception", e);
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
