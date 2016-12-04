package com.marketing.tool.domain.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.marketing.tool.domain.MasterDataType;
import com.marketing.tool.domain.MasterEntity;

@Entity
@Table(name="ResearchType")
@PrimaryKeyJoinColumn(name="id")
public class ResearchType extends MasterEntity {

	public ResearchType() {
		this.masterDataType = MasterDataType.RESEARCHTYPE;
	}
	
	@Column
	String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
