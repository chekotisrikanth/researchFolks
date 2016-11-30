package com.marketing.tool.domain.master;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.marketing.tool.domain.MasterEntity;

@Entity
@Table(name="country")
@PrimaryKeyJoinColumn(name="id")
public class Country extends MasterEntity {

	public Country() {
		this.masterDataType = MasterDataType.COUNTRY;
	}
    
    @Column(name="country_name",unique=true)
    private String countryName;
        
    
       public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    
}