package com.marketing.tool.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

//@MappedSuperclass
/**
 * @author anil
 *
 */
@Entity
@Table(name = "report_history")
public class ReportHistory implements Serializable{

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
	@Column(name="user_id" , nullable=false)
	private int userId;
	
	
	@NotNull	
	@Column(name="status_id" , nullable=false)
	private int statusId;
	
	
	@Column(name = "inserted_date",  updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date insertedDate;


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


	public int getStatusId() {
		return statusId;
	}


	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}


	public Date getInsertedDate() {
		return insertedDate;
	}


	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}
	
	
	
	
}
