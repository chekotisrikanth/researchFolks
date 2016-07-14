package com.marketing.tool.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.marketing.tool.domain.UserProfileType;
import com.marketing.tool.service.DownLoadReportService;
import com.marketing.tool.utility.FileUtils;
import com.marketing.tool.utility.Helper;
import com.marketing.tool.utility.SharedConstants;
import com.marketing.tool.vo.DownLoadReportVo;
@Controller
public class DownloadController {
	 private static final Logger LOGGER = LoggerFactory.getLogger(DownloadController.class);
	 @Autowired
	 private DownLoadReportService downLoadReportService;
	 
	   @RequestMapping(value = "/downloadReport/{reportId}", method = RequestMethod.GET) 
	   public void generatePDFReportForwarder(@PathVariable("reportId") Integer reportId,HttpServletRequest request, HttpServletResponse response) throws IOException
	   {
		   try {
			request.getRequestDispatcher("/downloadReport/"+SharedConstants.SOURCE+"/"+reportId).forward(request,response);
		} catch (ServletException e) {
			e.printStackTrace();
		}
		   
	   }
	 
	 @RequestMapping(value = "/downloadReport/{type}/{reportId}", method = RequestMethod.GET) 
	   public void generatePDFReport(@PathVariable String type ,@PathVariable("reportId") Integer reportId,HttpServletRequest request, HttpServletResponse response) throws IOException
	   {	
		 	LOGGER.debug("generatePDFReport entry {}",reportId);
   	
			 if(reportId == null ) {
				 response.getWriter().append("<B align='center'> No Reports Found For The Request <B>").flush();
				 return;
			 }
			
			final ServletContext servletContext = request.getSession().getServletContext();
			final File tempDirectory = (File) servletContext.getAttribute("javax.servlet.context.tempdir");
			final String temperotyFilePath = tempDirectory.getAbsolutePath();
			String emailId = Helper.getPrincipal();
			DownLoadReportVo vo = new DownLoadReportVo();
			vo.setEmailId(emailId);
			vo.setReportId(reportId);
			vo.setType(type);
			UserProfileType role = Helper.getRole();
			vo.setRole(role);
			ByteArrayOutputStream baos =  null;
			try {
				
				baos = downLoadReportService.getReportDocument(vo);
				
			}catch(Exception e) {
				LOGGER.debug("generatePDFReport entry {}",reportId);
			}
			String extention = vo.getFileName().substring(vo.getFileName().lastIndexOf(SharedConstants.DOT)+1);
			
			LOGGER.debug("generatePDFReport exit");			 
			
			response.setContentType(FileUtils.getFileextensionmap().get(extention));
			response.setHeader("Content-disposition", "attachment; filename="+ reportId+vo.getFileName().substring(vo.getFileName().lastIndexOf(SharedConstants.DOT)));
			
		   if(baos != null && baos.size() > 0)
		   {
			   try
			   {
					 OutputStream os = response.getOutputStream();
				     baos.writeTo(os);
				     os.flush();
				  
			   }catch (Exception e) {
				e.printStackTrace();
			 }
		   }
		  
	   }




}

