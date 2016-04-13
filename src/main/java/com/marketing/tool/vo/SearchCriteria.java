package com.marketing.tool.vo;

import java.io.Serializable;
/**
 * @author Anilkumar Ravula
 *
 */
public class SearchCriteria implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer catagryId ;
	private String industry ;
	private String  tittle;
	private String comIntl;
	private String message;
	private Integer pageNumber;
	private Integer maxResults;
	private Integer statusId;
	
	
	
	
	
	
	
	public Integer getStatusId() {
		return statusId;
	}

	public void setStatusId(Integer statusId) {
		this.statusId = statusId;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(Integer maxResults) {
		this.maxResults = maxResults;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getComIntl() {
		return comIntl;
	}

	public void setComIntl(String comIntl) {
		this.comIntl = comIntl;
	}

	public Integer getRespCode() {
		return catagryId;
	}

	public void setRespCode(Integer respCode) {
		this.catagryId = respCode;
	}
	public Integer getCatagryId() {
		return catagryId;
	}

	public void setCatagryId(Integer catagryId) {
		this.catagryId = catagryId;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	
	
	
	
	
	
}
