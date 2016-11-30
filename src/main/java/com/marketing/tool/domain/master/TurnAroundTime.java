package com.marketing.tool.domain.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.marketing.tool.domain.MasterEntity;

@Entity
@Table(name="TurnAroundTime")
@PrimaryKeyJoinColumn(name="id")
public class TurnAroundTime extends MasterEntity {

	public TurnAroundTime() {
		this.masterDataType = MasterDataType.TURNAROUNDTIME;
	}
	
	@Column
	String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
}
