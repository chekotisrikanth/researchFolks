package com.marketing.tool.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="stock_exchange")
public class StockExchange {

    @Id
    @Column(name="stock_exchange_id")
    @GeneratedValue
    private Integer stockExchangeId;
    
    @Column(name="name")
    private String name;
    
    @Column(name="company_id")    //tod: it is countryId
    private Integer companyId;

	

	public Integer getStockExchangeId() {
		return stockExchangeId;
	}

	public void setStockExchangeId(Integer stockExchangeId) {
		this.stockExchangeId = stockExchangeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}
    
    
   
    
}