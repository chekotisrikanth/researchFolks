package com.marketing.tool.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "report_status")
//@Table(name = "report_status", catalog = "test")
public class ReportStatus implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer reportStatusId;
	private ReportForm report;
	private User user;
	private String comments;
	
	
	public ReportStatus() {
	}

	
	@NotNull
	@Column
	private String userType;
	
	@NotNull
	@Column
	private String status;

	@Column(name="status_id")
	private Integer statusId;
	
	
	@Column(name="cycle_id")
	private int cycleId;
	

	public ReportStatus(ReportForm report, User user, String comments, String status) {
		this.report = report;
		this.user = user;
		this.comments = comments;
		this.status = status;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "report_status_id", unique = true, nullable = false)
	public Integer getReportStatusId() {
		return this.reportStatusId;
	}

	public void setReportStatusId(Integer reportStatusId) {
		this.reportStatusId = reportStatusId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "report_id")
	public ReportForm getReport() {
		return this.report;
	}

	public void setReport(ReportForm report) {
		this.report = report;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "comments")
	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Column(name = "status", nullable = false)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	public String getUserType() {
		return userType;
	}



	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public int getCycleId() {
		return cycleId;
	}

	public void setCycleId(int cycleId) {
		this.cycleId = cycleId;
	}

	
	
	
}
