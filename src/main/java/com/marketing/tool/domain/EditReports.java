package com.marketing.tool.domain;

import java.util.List;

public class EditReports {

	List<ReportForm> reports;
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

	
	
	
}
