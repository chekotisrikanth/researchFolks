package com.marketing.tool.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Author")
@PrimaryKeyJoinColumn(name="id")  
public class Author extends User {
	
      
    @NotEmpty
    @Size(max = 50)
    @Column(name = "country", nullable = false)
    private String country;
    
    @NotEmpty
    @Column(name = "state", nullable = false)
    private String state;
    
    @NotEmpty
    @Column(name = "biodata", nullable = false)
    private String biodata;
    
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "AuthorKeySkill", joinColumns = { 
			@JoinColumn(name = "authorId", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "skillId", 
					nullable = false, updatable = false) })
    private Set<Keyskills> keyskills;  
    
    
    
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

	
	public String getBiodata() {
		return biodata;
	}

	public void setBiodata(String biodata) {
		this.biodata = biodata;
	}

	public Set<Keyskills> getKeyskills() {
		return keyskills;
	}

	public void setKeyskills(Set<Keyskills> keyskills) {
		this.keyskills = keyskills;
	}

	public boolean getIsAgreedTC() {
		return isAgreedTC;
	}

	public void setIsAgreedTC(boolean isAgreedTC) {
		this.isAgreedTC = isAgreedTC;
	}

	public Author(Integer  id) {
		super(id);
	}

	public Author() {
		// TODO Auto-generated constructor stub
	}
    
	@Override
	public String toString() {
		return "Author [name=" + firstName + ", email=" + emailId + ", phone=" + mobileNo + ", country=" + country + ", state="
				+ state + ", title=" + title + " keyskills=" + keyskills + "]";
	}
    

}
