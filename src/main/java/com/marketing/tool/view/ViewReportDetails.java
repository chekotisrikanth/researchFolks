package com.marketing.tool.view;

import java.util.List;

import com.marketing.tool.domain.Author;
import com.marketing.tool.domain.ReportForm;

public class ViewReportDetails {
	
	ReportForm report;
	Author reportAuthor;
	List<ReportForm> latestPublishings;
	
	public ReportForm getReport() {
		return report;
	}
	public void setReport(ReportForm report) {
		this.report = report;
	}
	public Author getReportAuthor() {
		return reportAuthor;
	}
	public void setReportAuthor(Author user) {
		this.reportAuthor = user;
	}
	public List<ReportForm> getLatestPublishings() {
		return latestPublishings;
	}
	public void setLatestPublishings(List<ReportForm> latestPublishings) {
		this.latestPublishings = latestPublishings;
	}
	
	
	

}
