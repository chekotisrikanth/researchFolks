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
    @Column(name = "city", nullable = false)
    private String city;
    
    @NotEmpty
    @Column(name = "occupation", nullable = false)
    private String occupation;
    
    
    @Column(name = "isAgreedTC", nullable = false)
    private boolean isAgreedTC;
    
    @Size(max = 50)
    @Column(name = "userName", nullable = false)    
    private String userName;
    
    
    
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setAgreedTC(boolean isAgreedTC) {
		this.isAgreedTC = isAgreedTC;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [country=");
		builder.append(country);
		builder.append(", city=");
		builder.append(city);
		builder.append(", occupation=");
		builder.append(occupation);
		builder.append(", isAgreedTC=");
		builder.append(isAgreedTC);
		builder.append(", userName=");
		builder.append(userName);
		builder.append("]");
		return builder.toString();
	}
    
	
    

}
