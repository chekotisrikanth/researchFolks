package com.marketing.tool.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;


/**
 * @author anil
 *
 */
@Entity
@Table(name = "report_comments_alert")
public class ReportCommentsAlert implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
    @Column(name = "id", nullable = false, updatable = false)
	private Integer id;
	
	
	@NotNull	
    @Column(name = "report_id", nullable = false, updatable = false)
	private Integer reportId;
	
	
	
	
	@NotNull	
	@Column(name="userId" , nullable=false)
	private int userId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId",nullable=false,insertable=false,updatable=false)
	private User user;
	
	
	@Column(name = "last_seen_date",nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastSeenDate;

	
	
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getReportId() {
		return reportId;
	}


	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public Date getLastSeenDate() {
		return lastSeenDate;
	}


	public void setLastSeenDate(Date lastSeenDate) {
		this.lastSeenDate = lastSeenDate;
	}


	
	
	
}
