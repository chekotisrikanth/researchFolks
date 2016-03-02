package com.marketing.tool.validator;

import javax.validation.Validator;

import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

import com.marketing.tool.domain.CPDPReportForm;

public class FileUploadValidator 
{
	public static void validatefile(Object target, BindingResult result,String extention) {
		
		CPDPReportForm file = (CPDPReportForm)target;
		String ext = file.getReportImg().getOriginalFilename().split("\\.")[1];
		
		if(file.getReportImg().getSize()==0){
			result.reject("reportImg", "File Required");
		}
		else if(extention != null && !extention.contains(ext))
		{
			result.reject("reportImg", "File Not Support");
		}
			
	}

}
