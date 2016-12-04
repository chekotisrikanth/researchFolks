package com.marketing.tool.domain.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.marketing.tool.domain.MasterDataType;
import com.marketing.tool.domain.MasterEntity;


@Entity
@Table(name="UpdateCycle")
@PrimaryKeyJoinColumn(name="id")
public class UpdateCycle extends MasterEntity{

	
	
	public UpdateCycle() {
		this.masterDataType = MasterDataType.UPDATECYCLE;
	}
	
	@Column
	String cycle;

	public String getCycle() {
		return cycle;
	}

	public void setCycle(String cycle) {
		this.cycle = cycle;
	}
	
	
}
