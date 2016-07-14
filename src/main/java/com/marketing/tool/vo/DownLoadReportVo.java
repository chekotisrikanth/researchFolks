package com.marketing.tool.vo;

import com.marketing.tool.domain.UserProfileType;

/**
 * @author Anilkumar Ravula
 *
 */
public class DownLoadReportVo {
	private String emailId;
	private Integer userId;
	private Integer ReportId;
	private UserProfileType role;
	
	private String fileName;
	
	private String type;
	
	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getReportId() {
		return ReportId;
	}
	public void setReportId(Integer reportId) {
		ReportId = reportId;
	}
	
	
	public UserProfileType getRole() {
		return role;
	}
	public void setRole(UserProfileType role) {
		this.role = role;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DownLoadReportVo [emailId=");
		builder.append(emailId);
		builder.append(", userId=");
		builder.append(userId);
		builder.append(", ReportId=");
		builder.append(ReportId);
		builder.append("]");
		return builder.toString();
	}  
	
	
	
}
