package com.marketing.tool.validator;

import org.springframework.validation.BindingResult;

import com.marketing.tool.domain.ReportForm;

public class FileUploadValidator 
{
	public static void validatefile(Object target, BindingResult result) {
		
		ReportForm reportForm = (ReportForm)target;
		String ext = reportForm.getReportImg().getOriginalFilename().split("\\.")[1];
		String xlFormats ="xlsx,xlsm,xls";
		
		if(reportForm.getReportImg().getSize()==0){
			result.rejectValue("reportImg", "FileRequired");
			return;
		}
		
			if(ext != null)
		  {
				if(reportForm.getRepTypeId() != null && reportForm.getRepTypeId().equals(2)) {
					if(!xlFormats.contains(ext)) {
						result.rejectValue("reportImg", "FileNotAllowed");
					}
				}else if(!(ext.contains("ppt") || ext.contains("docx") || ext.contains("doc")))
					if(!"Other".contains(ext)) {
						result.rejectValue("reportImg", "FileNotAllowed");
					}
			}else {
				result.rejectValue("reportImg", "FileNotAllowed");
			}
			
			
	}

}
