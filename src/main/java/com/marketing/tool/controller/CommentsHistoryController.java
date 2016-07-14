package com.marketing.tool.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marketing.tool.domain.User;
import com.marketing.tool.service.LoginUserService;
import com.marketing.tool.service.ReportCommentsService;
import com.marketing.tool.utility.Helper;
import com.marketing.tool.vo.ReportCommentsHistoryList;
@Controller
@RequestMapping("/comments")
public class CommentsHistoryController {
	 private static final Logger LOGGER = LoggerFactory.getLogger(CommentsHistoryController.class);
	 @Autowired
	 private ReportCommentsService reportCommentsService;
	 @Autowired
	 private LoginUserService loginUserService;
	 
	 @RequestMapping(value = "/getComments/{reportId}", method = {RequestMethod.GET,RequestMethod.POST}) 
	   public @ResponseBody ReportCommentsHistoryList getReportComments(@PathVariable("reportId") Integer reportId) throws IOException
	   {	
		 	 LOGGER.debug("generatePDFReport entry {}",reportId);
			 ReportCommentsHistoryList res = null;

			 if(reportId != null ) {
				 try {
						res = reportCommentsService.getReportCommentsForReport(reportId);
						User user = loginUserService.findByEmailId(Helper.getPrincipal());
						//update last Seendate
						reportCommentsService.updateOrInsert(reportId, user.getId());
					}catch(Exception e) {
						LOGGER.debug("generatePDFReport entry {}",reportId);
					}		
			}
			
			return res;
	   }

}
