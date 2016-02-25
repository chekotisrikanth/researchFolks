package com.marketing.tool.domain;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Admin extends User {
	
	    
    @Size(max = 50)
    @Column(name = "designation", nullable = true)
    private String designation;
    
    
    @Column(name = "profilePic", nullable = true)
    private Blob profilePic;


	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	
	public Blob getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(Blob profilePic) {
		this.profilePic = profilePic;
	}

	public Admin(Integer  id) {
		super(id);
	}

	public Admin() {
		// TODO Auto-generated constructor stub
	}
    
	@Override
	public String toString() {
		return "Admin [name=" + firstName + ", email=" + emailId + ", phone="  + ", accountType=" + super.getAccountType() + ", designation="
				+ designation + ", title=" + title + "]";
	}
    

}
