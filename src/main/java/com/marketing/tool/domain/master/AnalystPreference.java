package com.marketing.tool.domain.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.marketing.tool.domain.MasterEntity;

@Entity
@Table(name="AnalystPreference")
@PrimaryKeyJoinColumn(name="id")
public class AnalystPreference extends MasterEntity {

	public AnalystPreference() {
		this.masterDataType = MasterDataType.ANALYSTPREFERANCE;
	}
	
	@Column
	String preference;

	public String getPreference() {
		return preference;
	}

	public void setPreference(String preference) {
		this.preference = preference;
	}
	
	
	
}
