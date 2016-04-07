package com.marketing.tool.validator;

import org.springframework.validation.BindingResult;

import com.marketing.tool.domain.ReportForm;

public class FileUploadValidator 
{
	public static void validatefile(Object target, BindingResult result,String extention) {
		
		ReportForm file = (ReportForm)target;
		String ext = file.getReportImg().getOriginalFilename().split("\\.")[1];
		
		if(file.getReportImg().getSize()==0){
			result.rejectValue("reportImg", "FileRequired");
		}
		else if(extention != null && !extention.contains(ext))
		{
			result.rejectValue("reportImg", "FileNotAllowed");
		}
			
	}

}
