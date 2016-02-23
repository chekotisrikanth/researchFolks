package com.marketing.tool.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

//@MappedSuperclass
/**
 * @author anil
 *
 */
@Entity
@Table(name = "report")  
@Inheritance(strategy=InheritanceType.JOINED)
public class ReportForm {

	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE)
    @Column(name = "reportId", nullable = false, updatable = false)
	private Integer reportId;
	
	@NotEmpty
	@Column(name="reportTitle" , nullable=false)
	private String reportTitle;
	
	
	@NotEmpty
	@Column(name="industry" , nullable=false)
	private String industry;
	
	@NotEmpty
	@Column(name="country" , nullable=false)
	private String country;
	
	
	@Column(name="publishingDate")
	//@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date publishingDate;

	@Column(name="price" , nullable=false)
	private float price;
	
	@NotEmpty
	@Column(name="overview" , nullable=false)
	private String overview;
	
	@NotEmpty
	@Column(name="tableOfContents" , nullable=false)
	private String tableOfContents;
	
	// new cloumns start
	
	
	@NotEmpty
	@Column(name="updateCycle" , nullable=false)
	private String updateCycle;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "report",cascade = CascadeType.ALL)
	private List<ReportStatus> reportStatuses = null;

	@Column(name="report" , nullable=true)
	private byte[] report;

		
	
	

	public ReportForm(Integer id) {
           this.reportId = id;
	}
	
	public ReportForm() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Integer getReportId() {
		return reportId;
	}

	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}

	public String getReportTitle() {
		return reportTitle;
	}

	public void setReportTitle(String reportTitle) {
		this.reportTitle = reportTitle;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Date getPublishingDate() {
		return publishingDate;
	}

	public void setPublishingDate(Date publishingDate) {
		this.publishingDate = publishingDate;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getOverview() {
		return overview;
	}

	public void setOverview(String overview) {
		this.overview = overview;
	}

	public String getTableOfContents() {
		return tableOfContents;
	}

	public void setTableOfContents(String tableOfContents) {
		this.tableOfContents = tableOfContents;
	}

	public String getUpdateCycle() {
		return updateCycle;
	}

	public void setUpdateCycle(String updateCycle) {
		this.updateCycle = updateCycle;
	}

	public List<ReportStatus> getReportStatuses() {
		return reportStatuses;
	}

	public void setReportStatuses(List<ReportStatus> reportStatuses) {
		this.reportStatuses = reportStatuses;
	}

	public byte[] getReport() {
		return report;
	}

	public void setReport(byte[] report) {
		this.report = report;
	}

	@Override
	public String toString() {
		return " report created " + reportTitle + " id " + reportId +" status " + reportStatuses;
		
	}
	
}
