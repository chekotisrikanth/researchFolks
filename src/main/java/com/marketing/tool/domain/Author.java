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
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Author")
@PrimaryKeyJoinColumn(name="id")  
public class Author extends User {
	
      
    @NotEmpty
    @Size(max = 50)
    @Column(name = "country_id", nullable = false)
    private String country;
    
    @NotEmpty
    @Column(name = "city", nullable = false)
    private String city;
    
    @NotEmpty
    @Column(name = "bio", nullable = false)
    private String bio;
    
    
    @Column(name = "mobile", nullable = false)
   	protected String mobileNo;
    
    
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "AuthorKeySkill", joinColumns = { 
			@JoinColumn(name = "authorId", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "skillId", 
					nullable = false, updatable = false) })
    private Set<Keyskills> keyskills;  
    
    

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	

	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getBiodata() {
		return bio;
	}

	public void setBiodata(String biodata) {
		this.bio = biodata;
	}

	public Set<Keyskills> getKeyskills() {
		return keyskills;
	}

	public void setKeyskills(Set<Keyskills> keyskills) {
		this.keyskills = keyskills;
	}

	

	public Author(Integer  id) {
		super(id);
	}
	
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public Author() {
		// TODO Auto-generated constructor stub
	}

	
    
}
