package com.marketing.tool.vo;

public class ReportVo {
	
	private Integer reportId;
	private String reportTitle;
	private String industry;
	private String country;
	private String userName;
	private Integer comIntl;
	private String publishingDate;
	
	private String haveComments = "N";
	
	
	private String comIntlString;
	
	private Integer comntCnt;
	
	private Integer userId;
	
	
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getComntCnt() {
		return comntCnt;
	}
	public void setComntCnt(Integer comntCnt) {
		this.comntCnt = comntCnt;
	}
	public String getComIntlString() {
		return comIntlString;
	}
	public void setComIntlString(String comIntlString) {
		this.comIntlString = comIntlString;
	}
	public String getPublishingDate() {
		return publishingDate;
	}
	public void setPublishingDate(String publishingDate) {
		this.publishingDate = publishingDate;
	}
	public Integer getComIntl() {
		return comIntl;
	}
	public void setComIntl(Integer comIntl) {
		this.comIntl = comIntl;
	}
	public Integer getReportId() {
		return reportId;
	}
	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}
	public String getReportTitle() {
		return reportTitle;
	}
	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHaveComments() {
		return haveComments;
	}
	public void setHaveComments(String haveComments) {
		this.haveComments = haveComments;
	}
	
	
	
	
	

}
