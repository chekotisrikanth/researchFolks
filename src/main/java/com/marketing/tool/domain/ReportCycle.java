package com.marketing.tool.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="report_cycle")
public class ReportCycle {

    @Id
    @Column(name="status_id")
    @GeneratedValue
    private Integer statusId;
    
    @Column(name="status_name")
    private String statusName;

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
        
    
    
    
}