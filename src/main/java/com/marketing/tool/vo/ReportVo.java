package com.marketing.tool.vo;

import java.util.Date;

public class ReportVo {
	
	private Integer reportId;
	private String reportTitle;
	private String industry;
	private String country;
	private String userName;
	private Integer comIntl;
	private Date publishingDate;
	
	private String comIntlString;
	
	
	
	public String getComIntlString() {
		return comIntlString;
	}
	public void setComIntlString(String comIntlString) {
		this.comIntlString = comIntlString;
	}
	public Date getPublishingDate() {
		return publishingDate;
	}
	public void setPublishingDate(Date publishingDate) {
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
	
	
	
	
	

}
