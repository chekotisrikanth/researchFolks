package com.marketing.tool.domain;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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

import com.marketing.tool.domain.master.Country;
import com.marketing.tool.utility.DateUtills;

//@MappedSuperclass
/**
 * @author anil
 *
 */
@Entity
@Table(name = "report")  
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="profiletype", discriminatorType=DiscriminatorType.STRING)
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
	@Size(max=100)
	@Column(name="reportTitle" , nullable=false)
	private String reportTitle;
	
	
	@NotEmpty
	@Lob
	@Size(max=1000)
	@Column(name="industry" , nullable=false)
	private String industry;
	
	@NotNull
	@Column(name="countryId" , nullable=false)
	private Integer country;
	
	//TODO: nned  to update after dev
	@Column(name="insertedDate", nullable=true)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss.SSS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date insertedDate;
	
	@NotEmpty
	@Column(name="price" , nullable=false)
	@Size(max=20)
	private String price;
	
	@NotEmpty
	@Size(max=1500)
	@Column(name="overview" , nullable=false)
	private String overview;
	
	@NotEmpty
	@Size(max=1500)
	@Column(name="tableOfContents" , nullable=false)
	private String tableOfContents;
	
	
	
	@NotEmpty
	@Column(name="updateCycle" , nullable=false)
	private String updateCycle;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "report",cascade = CascadeType.ALL)
	private List<ReportStatus> reportStatuses = null;
	
	
/*	@OneToMany(fetch = FetchType.LAZY, mappedBy = "report",cascade = CascadeType.ALL)
	private List<CPDPReportForm> cdpdReport = null;*/
	
	

	/*@Column(name="report" , nullable=true)
	private byte[] report;*/
	
	@Column(name="filePath" , nullable=true)
	private String filePath;
	
	@Transient
	private Integer publisherId;
	@Transient
	private Integer reporterId;
	@NotNull
	@Column(name="reptype_id" , nullable=false)
	private Integer repTypeId;
	
	@Transient
	private MultipartFile reportImg;
	
	
	@Column(name="company_intl_type" , nullable=true)
	private Integer comIntl;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "report",cascade = CascadeType.ALL)
	private List<ReportComments> reportComments = null;
	//Country
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "countryId", insertable =false,updatable = false)
	private Country countryObj;
	
		
	@Transient
	private String haveComments;
	@Transient
	private Integer comntCnt;
	
	//@NotEmpty
		@Column(name="publishingDate", nullable=true)
		//@Temporal(TemporalType.DATE)
		//@Date
		 //@DateTimeFormat(style = "MM-dd-yyyy")
		//@DateTimeFormat(pattern="MM/DD/YYYY")
		//@DateTimeFormat(pattern="MM-dd-yyyy")
		private Date publishingDate;
		
		public Date getPublishingDate() {
			return publishingDate;
		}

		public void setPublishingDate(Date publishingDate) {
			this.publishingDate = publishingDate;
		}
	
	

	public Country getCountryObj() {
		return countryObj;
	}

	public void setCountryObj(Country countryObj) {
		this.countryObj = countryObj;
	}

	public String getHaveComments() {
		return haveComments;
	}

	public void setHaveComments(String haveComments) {
		this.haveComments = haveComments;
	}

	public Integer getComntCnt() {
		return comntCnt;
	}

	public void setComntCnt(Integer comntCnt) {
		this.comntCnt = comntCnt;
	}

	public List<ReportComments> getReportComments() {
		return reportComments;
	}

	public void setReportComments(List<ReportComments> reportComments) {
		this.reportComments = reportComments;
	}

	
	public Integer getComIntl() {
		return comIntl;
	}

	public void setComIntl(Integer comIntl) {
		this.comIntl = comIntl;
	}

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

	
	

	public Integer getCountry() {
		return country;
	}

	public void setCountry(Integer country) {
		this.country = country;
	}

	public Date getInsertedDate() {
		return insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
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
	
	
	public Integer getRepTypeId() {
		return repTypeId;
	}

	public void setRepTypeId(Integer repTypeId) {
		this.repTypeId = repTypeId;
	}
	
	@Transient
	public String getDiscriminatorValue(){
	    DiscriminatorValue val = this.getClass().getAnnotation(DiscriminatorValue.class);

	    return val == null ? null : val.value();
	}

	@Override
	public String toString() {
		return " report created " + reportTitle + " id " + reportId +" status " + reportStatuses;
		
	}
	
}
