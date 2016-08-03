package com.marketing.tool.domain;
// Generated Jul 25, 2016 12:17:10 PM by Hibernate Tools 4.3.1.Final

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CustomerAuthorFavListId implements Serializable {

	private Integer authorid;
	private Integer customerid;
	private Integer reportid;

	public CustomerAuthorFavListId() {
	}

	public CustomerAuthorFavListId(Integer authorid, Integer customerid,Integer reportid) {
		this.authorid = authorid;
		this.customerid = customerid;
		this.reportid = reportid;
	}

	@Column(name = "authorid", nullable = false)
	public Integer getAuthorid() {
		return this.authorid;
	}

	public void setAuthorid(Integer authorid) {
		this.authorid = authorid;
	}

	@Column(name = "customerid", nullable = false)
	public Integer getCustomerid() {
		return this.customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}
	
	
	@Column(name = "reportid", nullable = false)
	public Integer getReportid() {
		return reportid;
	}

	public void setReportid(Integer reportid) {
		this.reportid = reportid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof CustomerAuthorFavListId))
			return false;
		CustomerAuthorFavListId castOther = (CustomerAuthorFavListId) other;

		return (this.getAuthorid() == castOther.getAuthorid()) && (this.getCustomerid() == castOther.getCustomerid())
				&& (this.getReportid() == castOther.getReportid());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getAuthorid();
		result = 37 * result + this.getCustomerid();
		result = 37 * result + this.getReportid();
		return result;
	}

}
