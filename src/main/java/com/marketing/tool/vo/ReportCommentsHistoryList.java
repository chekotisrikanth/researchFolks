package com.marketing.tool.vo;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

//@MappedSuperclass
/**
 * @author anil
 *
 */

//@Inheritance(strategy=InheritanceType.JOINED)
public class ReportCommentsHistoryList implements Serializable{

	@NotNull
	private List<ReportCommentsHistory> reports;
	
	private Integer reportId;
	
	
	
	
	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public List<ReportCommentsHistory> getReports() {
		return reports;
	}

	public void setReports(List<ReportCommentsHistory> reports) {
		this.reports = reports;
	}
	
	
	
	
	
		
	
}
