package com.marketing.tool.service;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import com.marketing.tool.domain.ReportForm;

public interface ReportFormService {
	
	
	ReportForm save(ReportForm reportForm) throws IOException,ParseException;

	List<ReportForm> getAllReports();
	
	ReportForm findByReportId(Integer reportFormId);
	
	
}
