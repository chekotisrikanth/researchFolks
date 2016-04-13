package com.marketing.tool.domain;

import java.util.List;

import com.marketing.tool.vo.ReportVo;

public class EditReports {

	List<ReportForm> reports;
	List<ReportVo> reportsList;
	long totalPages;
	
	

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public List<ReportForm> getReports() {
		return reports;
	}

	public void setReports(List<ReportForm> reports) {
		this.reports = reports;
	}

	public List<ReportVo> getReportsList() {
		return reportsList;
	}

	public void setReportsList(List<ReportVo> reportsList) {
		this.reportsList = reportsList;
	}

	
	
	
}
