package com.marketing.tool.domain;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

//@MappedSuperclass
/**
 * @author anil
 *
 */

//@Inheritance(strategy=InheritanceType.JOINED)
public class ReportCommentsVo implements Serializable{

	@NotNull
	private List<ReportComments> reports;
	
	private Integer userId;
	private String  emailId;
	private UserProfileType role;
	
	
	
	public UserProfileType getRole() {
		return role;
	}

	public void setRole(UserProfileType role) {
		this.role = role;
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

	public List<ReportComments> getReports() {
		return reports;
	}

	public void setReports(List<ReportComments> reports) {
		this.reports = reports;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReportCommentsVo [reports=");
		builder.append(reports);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
		
	
}
