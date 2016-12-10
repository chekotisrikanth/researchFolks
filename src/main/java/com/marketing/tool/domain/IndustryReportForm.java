package com.marketing.tool.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("industryreport")
public class IndustryReportForm extends ReportForm {
	
	
	
	
	
	
/*	@NotNull
	@Column(name="company_intl_type",nullable=false)
	private Integer comIntl;
	
	public Integer getComIntl() {
		return comIntl;
	}

	public void setComIntl(Integer comIntl) {
		super.setComIntl(comIntl);
		this.comIntl = comIntl;
	}*/

	

	@Override
	public String toString() {
		return super.toString();
	}
}
