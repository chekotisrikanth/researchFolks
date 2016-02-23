package com.marketing.tool.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Customer")
@PrimaryKeyJoinColumn(name="id")
public class Customer extends User {
	
    @NotEmpty
    @Size(max = 50)
    @Column(name = "country", nullable = false)
    private String country;
    
    @NotEmpty
    @Column(name = "state", nullable = false)
    private String state;
    
    @NotEmpty
    @Column(name = "occupation", nullable = false)
    private String occupation;
    
    
    @Column(name = "isAgreedTC", nullable = false)
    private boolean isAgreedTC;


	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public boolean getIsAgreedTC() {
		return isAgreedTC;
	}

	public void setIsAgreedTC(boolean isAgreedTC) {
		this.isAgreedTC = isAgreedTC;
	}

	public Customer(Integer  id) {
		super(id);
	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}
    
	@Override
	public String toString() {
		return "Customer [name=" + firstName + ", email=" + emailId + ", phone=" + mobileNo + ", country=" + country + ", state="
				+ state + ", title=" + title + "]";
	}
    

}
