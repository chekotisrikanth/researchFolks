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
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

//@MappedSuperclass
/**
 * @author anil
 *
 */
@Entity
@Table(name = "report")  
@Inheritance(strategy=InheritanceType.JOINED)
public class ReportForm {

	public MultipartFile getReportImg() {
		return reportImg;
	}

	public void setReportImg(MultipartFile reportImg) {
		this.reportImg = reportImg;
	}

	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE)
    @Column(name = "reportId", nullable = false, updatable = false)
	private Integer reportId;
	
	@NotEmpty
	@Column(name="reportTitle" , nullable=false)
	private String reportTitle;
	
	
	@NotEmpty
	@Lob
	@Size(max=1000)
	@Column(name="industry" , nullable=false)
	private String industry;
	
	@NotEmpty
	@Column(name="country" , nullable=false)
	private String country;
	
	
	@Column(name="insertedDate", nullable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss.SSS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date insertedDate;
	@NotNull
	@Column(name="price" , nullable=false)
	private String price;
	
	@NotEmpty
	@Lob
	@Size(max=1500)
	@Column(name="overview" , nullable=false)
	private String overview;
	
	@NotEmpty
	@Lob
	@Size(max=1500)
	@Column(name="tableOfContents" , nullable=false)
	private String tableOfContents;
	
	// new cloumns start
	
	
	@NotEmpty
	@Column(name="updateCycle" , nullable=false)
	private String updateCycle;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "report",cascade = CascadeType.ALL)
	private List<ReportStatus> reportStatuses = null;

	/*@Column(name="report" , nullable=true)
	private byte[] report;*/
	
	@Column(name="filePath" , nullable=true)
	private String filePath;
	
	@Transient
	private Integer publisherId;
	@Transient
	private Integer reporterId;
	
	
	
	@Transient
	private MultipartFile reportImg;
	
	@NotEmpty
	@Column(name="publishingDate", nullable=false)
	private String publishingDate;

	public Integer getPublisherId() {
		return publisherId;
	}

	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}



	public Integer getReporterId() {
		return reporterId;
	}

	public void setReporterId(Integer reporterId) {
		this.reporterId = reporterId;
	}

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

	

	public Date getInsertedDate() {
		return insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}

	public String getPublishingDate() {
		return publishingDate;
	}

	public void setPublishingDate(String publishingDate) {
		this.publishingDate = publishingDate;
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

	/*public byte[] getReport() {
		return report;
	}

	public void setReport(byte[] report) {
		this.report = report;
	}*/
	

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return " report created " + reportTitle + " id " + reportId +" status " + reportStatuses;
		
	}
	
}
