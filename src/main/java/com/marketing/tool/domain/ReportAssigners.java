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
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

//@MappedSuperclass
/**
 * @author anil
 *
 */
@Entity
@Table(name = "report_assigners")  
//@Inheritance(strategy=InheritanceType.JOINED)
public class ReportAssigners implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//@Id 
	//@GeneratedValue(strategy=GenerationType.TABLE)
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "reportAssignersId", nullable = false, updatable = false)
	private Integer reportAssignersId;
	
	//@Id
	@NotNull
	//@Pattern(regexp = "[0-9]")
    @Column(name = "reportId", nullable = false, updatable = false)
	private Integer reportId;
	//@Id
	@NotNull
	//@Pattern(regexp = "[0-9]")
	@Column(name="reviwerId" , nullable=false)
	private Integer reviwerId;
	
	
	
	@NotNull
	//@Pattern(regexp = "[0-9]")
	@Column(name="publisherId" , nullable=false)
	private Integer publisherId;

	@Column(name = "inserted_date", insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date insertedDate;
	// new cloumns start
	@NotNull
	@Column(name="active" , nullable=false)
	private String active="Y";
	
	

	public Integer getReportAssignersId() {
		return reportAssignersId;
	}

	public void setReportAssignersId(Integer reportAssignersId) {
		this.reportAssignersId = reportAssignersId;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	

	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public Integer getReviwerId() {
		return reviwerId;
	}

	public void setReviwerId(Integer reviwerId) {
		this.reviwerId = reviwerId;
	}

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}

	public Date getInsertedDate() {
		return insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}
	
	
	/*@NotEmpty
	@Column(name="updateCycle" , nullable=false)
	private String updateCycle;*/
	
	/*@OneToMany(fetch = FetchType.LAZY, mappedBy = "report",cascade = CascadeType.ALL)
	private List<ReportStatus> reportStatuses = null;
*/
	
	
	
	
}
