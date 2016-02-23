package com.marketing.tool.service;

import java.util.List;

import com.marketing.tool.domain.ReportForm;

public interface ReportFormService {
	
	
	ReportForm save(ReportForm reportForm);

	List<ReportForm> getAllReports();
	
	ReportForm findByReportId(Integer reportFormId);
	
	
}
