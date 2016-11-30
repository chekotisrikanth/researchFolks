package com.marketing.tool.domain.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.marketing.tool.domain.MasterEntity;

@Entity
@Table(name="Units")
@PrimaryKeyJoinColumn(name="id")
public class Units extends MasterEntity {

	public Units() {
		this.masterDataType = MasterDataType.UNITS;
	}
	
	@Column
	String unit;

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	
}
