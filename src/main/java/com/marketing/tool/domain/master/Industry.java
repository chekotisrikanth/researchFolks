package com.marketing.tool.domain.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.marketing.tool.domain.MasterDataType;
import com.marketing.tool.domain.MasterEntity;

@Entity
@Table(name="Industry")
@PrimaryKeyJoinColumn(name="id")
public class Industry extends MasterEntity {

	public Industry() {
		this.masterDataType = MasterDataType.INDUSTRY;
	}
	
	@Column
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
