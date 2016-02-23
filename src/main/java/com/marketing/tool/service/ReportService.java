package com.marketing.tool.service;

import java.util.List;

import com.marketing.tool.domain.ReportForm;
import com.marketing.tool.domain.ViewReports;

public interface ReportService {
	

	List<ReportForm> getAllReports();
	List<ReportForm> findByReportIdIn(List<Integer> reportId);
	ReportForm findByReportId(Integer reportFormId);
	void updateReports(ViewReports viewReports);
}
