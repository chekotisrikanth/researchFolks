package com.marketing.tool.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import org.springframework.web.multipart.MultipartFile;

//@MappedSuperclass
/**
 * @author anil
 *
 */

//@Inheritance(strategy=InheritanceType.JOINED)
@Entity
@Table(name = "report_comments") 
public class ReportComments implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
    @Column(name = "id", nullable = false, updatable = false)
	private Integer id;
	
	@NotNull
	 @Column(name = "reportId", nullable = false, updatable = false)
	private Integer reportId;
	
	 @NotNull
	 @Column(name = "userId", nullable = false)
	public Integer userId;
	
	 
	@Column(name = "comment", nullable = true)
	private String comment;
	
	@Column(name = "filePath", nullable = true)
	private String filePath;
	
	@Transient
	public MultipartFile reportFile;

	public Integer assignee;
	
	

	


	public Integer getAssignee() {
		return assignee;
	}


	public void setAssignee(Integer assignee) {
		this.assignee = assignee;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public Integer getReportId() {
		return reportId;
	}


	public void setReportId(Integer reportId) {
		this.reportId = reportId;
	}





	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getComment() {
		return comment;
	}


	public void setComment(String comment) {
		this.comment = comment;
	}


	public MultipartFile getReportFile() {
		return reportFile;
	}


	public void setReportFile(MultipartFile reportFile) {
		this.reportFile = reportFile;
	}


	
	
	
		
	
}
