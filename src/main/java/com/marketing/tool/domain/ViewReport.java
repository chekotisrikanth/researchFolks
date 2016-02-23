package com.marketing.tool.domain;

import java.util.List;

public class ViewReport {
	
	private int reportId;
	
	private List<String> reviewerIds;
	private List<String> publisersIds;
	
	
	public int getReportId() {
		return reportId;
	}
	public void setReportId(int reportId) {
		this.reportId = reportId;
	}
	public List<String> getReviewerIds() {
		return reviewerIds;
	}
	public void setReviewerIds(List<String> reviewerIds) {
		this.reviewerIds = reviewerIds;
	}
	public List<String> getPublisersIds() {
		return publisersIds;
	}
	public void setPublisersIds(List<String> publisersIds) {
		this.publisersIds = publisersIds;
	}
	
	

}
