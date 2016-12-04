package com.marketing.tool.domain.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.marketing.tool.domain.MasterDataType;
import com.marketing.tool.domain.MasterEntity;

@Entity
@Table(name="Occupation")
@PrimaryKeyJoinColumn(name="id")
public class Occupation extends MasterEntity {

	public Occupation() {
		this.masterDataType = MasterDataType.OCCUPATION;
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
