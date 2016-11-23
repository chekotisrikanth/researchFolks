package com.marketing.tool.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="country")
@PrimaryKeyJoinColumn(name="id")
public class Country extends MasterEntity {

    
    @Column(name="country_name")
    private String countryName;
        
    
       public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    
}