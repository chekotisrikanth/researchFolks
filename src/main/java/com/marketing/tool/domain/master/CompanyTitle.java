package com.marketing.tool.domain.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.marketing.tool.domain.MasterEntity;

@Entity
@Table(name="CompanyTitle")
@PrimaryKeyJoinColumn(name="id")
public class CompanyTitle extends MasterEntity{

	public CompanyTitle() {
		this.masterDataType = MasterDataType.COMPANYTITLE;
	}
	
	@Column
	String title;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
