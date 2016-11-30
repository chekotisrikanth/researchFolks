package com.marketing.tool.domain.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.marketing.tool.domain.MasterEntity;

@Entity
@Table(name="Currency")
@PrimaryKeyJoinColumn(name="id")
public class Currency extends MasterEntity {

	public Currency() {
		this.masterDataType = MasterDataType.CURRENCY;
	}
	
	@Column
	String currencyName;

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}
	
	
	
}
