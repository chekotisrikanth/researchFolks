package com.marketing.tool.service.impl;

import java.io.ByteArrayOutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.tool.domain.ReportForm;
import com.marketing.tool.domain.UserProfileType;
import com.marketing.tool.exception.ReportAccessExpetion;
import com.marketing.tool.repository.ReportCommentsRepository;
import com.marketing.tool.repository.ReportRepository;
import com.marketing.tool.service.DownLoadReportService;
import com.marketing.tool.service.ReportAssignerService;
import com.marketing.tool.utility.FileUtils;
import com.marketing.tool.utility.SharedConstants;
import com.marketing.tool.utility.StringUtil;
import com.marketing.tool.vo.DownLoadReportVo;

/**
 * @author Anilkumar Ravula
 *
 */
@Service
public class DownLoadReportServiceImpl implements DownLoadReportService {
	 private static final Logger LOGGER = LoggerFactory.getLogger(DownLoadReportServiceImpl.class);
	 @Autowired
	 private ReportAssignerService reportAssignerService;
	 
	 @Autowired
	 private ReportRepository reportRepository;
	 @Autowired
	 private ReportCommentsRepository reportCommentsRepository;
	@Override
	public ByteArrayOutputStream getReportDocument(DownLoadReportVo reportVo) {
		String methodName = "getReportDocument";
		
		LOGGER.debug(" method entry {} input {}  ",methodName,reportVo);
    	
		ByteArrayOutputStream resp = null;
    	
    	try {
    		Integer userId = null;
    		//validate Report Accessible to LoginUser 
    		 if(!reportVo.getRole().equals(UserProfileType.ADMIN)) {    			 
    			 userId = reportAssignerService.reportAccessForUser(reportVo.getReportId(), reportVo.getEmailId(),reportVo.getRole(),reportVo.getType());
    		 }
    		 if(userId == null || userId ==0) {
    			 throw new ReportAccessExpetion("USer Not Have Access To DownLoad This Report");
    		 }
    		 String filePath = null;
    		 if(SharedConstants.COMMENTS.equals(reportVo.getType())) {
    			 //gte Path from Comments
    			 filePath = reportCommentsRepository.getReportCommentsFilePath(reportVo.getReportId());
    		 } else {
			 	//get FilePath
	    		ReportForm repForm = reportRepository.findByReportId(reportVo.getReportId());
	    		filePath = repForm.getFilePath();
	    		filePath = StringUtil.buildString(SharedConstants.FILE_PATH,filePath);
    		 }
	    		reportVo.setFileName(filePath.substring(filePath.lastIndexOf(SharedConstants.FILE_SEPERATOR)+1));

    	 	//build Response
    		resp = FileUtils.getByteArrayOutputStream(filePath);
    		
    	}	catch(Exception e) {
    		LOGGER.error("Exception raised  in  {} cause {} trace {}",methodName,e.getCause(),e);
    	}
    	
    	
    	LOGGER.debug("method {} exit ",methodName);
    	
	    return resp;
		
		
	}
/*	
	public static void main(String[] args) {
		System.out.println("rep\\r".substring("rep\\r".lastIndexOf("\\")+1));
	}
*/
}
