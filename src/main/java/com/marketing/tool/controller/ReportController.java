package com.marketing.tool.controller;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.marketing.tool.domain.PurchaseOrder;
import com.marketing.tool.domain.ReportForm;
import com.marketing.tool.domain.ViewReports;
import com.marketing.tool.service.AdminService;
import com.marketing.tool.service.AuthorService;
import com.marketing.tool.service.LoginUserService;
import com.marketing.tool.service.PurchaseOrderService;
import com.marketing.tool.service.ReportService;
import com.marketing.tool.utility.Helper;
import com.marketing.tool.validator.CreateFormValidator;
import com.marketing.tool.view.ViewReportDetails;

@Controller
public class ReportController {

	 private static final Logger LOGGER = LoggerFactory.getLogger(ReportController.class);
	    
	 ObjectMapper mapper = new ObjectMapper();
	  
	   @Autowired
	   private PurchaseOrderService orderService;
	 
	    @Autowired
	    private AdminService adminService;
	    
	    @Autowired
	    private CreateFormValidator createFormValidator;
	    
	    @Autowired
		private LoginUserService loginUserService;
	    
	    @Autowired
	    private ReportService reportFormService;
	    
	    @Autowired
	    private AuthorService authorService;
	    
	    @Autowired
	    private Helper helper;
	    
	         
	    @RequestMapping(value = "/secure/updateReports.html", method = RequestMethod.POST)
	    public String updateReports(@ModelAttribute("editreports") @Valid ViewReports viewReports, BindingResult result) {
	        reportFormService.updateReports(viewReports);
	        return "redirect:/secure/home/admin";
	    }
	    
	    @RequestMapping(value = "/public/getReport/{reportId}", method = RequestMethod.GET)
	    public ModelAndView getReport(@PathVariable Integer reportId) {
	         ReportForm report =  reportFormService.findByReportId(reportId);
	         ModelAndView model = new ModelAndView();
	         ViewReportDetails reportDetails = new ViewReportDetails();
	         reportDetails.setReport(report);
	         reportDetails.setReportAuthor(authorService.findById(report.getReportStatuses().get(0).getUser().getId()));
	         reportDetails.setLatestPublishings(reportFormService.findReportsByProfileType(report.getDiscriminatorValue()));
	         model.addObject("viewreport",reportDetails);
	         model.setViewName("reportDetails");
	        return model;
	    }
	    
	    
	    
	    @RequestMapping(value = "/secure/purchase/purchasereport.html", method = RequestMethod.GET)
	    public ModelAndView buyReport(@RequestParam(value = "reportid",required = false) Integer reportid,@ModelAttribute("form") @Valid PurchaseOrder order, BindingResult result) {
	    	LOGGER.debug("Received request for buy report");
	        ModelAndView modelAndView = new ModelAndView();
	        modelAndView.addObject("form", new PurchaseOrder());
	        modelAndView.addObject("reportid",reportid);
	        modelAndView.setViewName("purchase");
	        return modelAndView;
	    }
	    
	    @RequestMapping(value = "/secure/purchase/purchasereport.html", method = RequestMethod.POST)
	    public ModelAndView buyReport(@RequestParam(value = "reportid",required = true) Integer reportid) {
	    	LOGGER.debug("Received request for buy report");
	        ModelAndView modelAndView = new ModelAndView();
	        PurchaseOrder order = new PurchaseOrder();
	        Set<ReportForm> reportSet = new HashSet<ReportForm>();
	        reportSet.add(reportFormService.findByReportId(reportid));
	        order.setCustomer(helper.getPrincipalUser());
	        order.setReport(reportSet);
	        order.setPurchsedate(new Date());
	        PurchaseOrder purchaseResult = orderService.saveOrder(order);
	        modelAndView.addObject("txnId",purchaseResult.getTxnid());
	        modelAndView.setViewName("purchaseresult");
	        return modelAndView;
	    }
}
