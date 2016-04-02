package com.marketing.tool.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class IndustryReportForm extends ReportForm {
	
	
	
	
	@NotEmpty
	@Column(name="companyType",nullable=false)
	private String companyType;
	
	
	public String getCompanyType() {
		return companyType;
	}


	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}


	@Override
	public String toString() {
		return super.toString();
	}
}
