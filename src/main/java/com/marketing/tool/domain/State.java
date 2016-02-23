package com.marketing.tool.domain;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="state")
public class State {
    
    
    @Id
    @Column(name="state_id")
    @GeneratedValue
    private Integer stateId;
    
    @Column(name="state_name")
    private String stateName;
    
    @ManyToOne
    @JoinColumn(name="country_id", insertable = false, updatable = false)
    private Country country;
    
    @Column(name = "country_id")
    private Integer countryId;

    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }
    
    
    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
    
        
}

