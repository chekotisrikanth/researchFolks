package com.marketing.tool.domain;

import java.sql.Blob;
import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class AdminCreateForm {
	
	@NotEmpty
	private List titles;
	
	@NotEmpty
	private String firstName;
	private String lastName;
	
	@NotEmpty
	private String emailId;
	
	@NotEmpty
	private Integer mobileNo;
	private String designation;
	@NotEmpty
	private List accountTypes;
	private Blob profilePic;
	public List getTitles() {
		return titles;
	}
	public void setTitles(List titles) {
		this.titles = titles;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Integer getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Integer mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public List getAccountTypes() {
		return accountTypes;
	}
	public void setAccountTypes(List accountTypes) {
		this.accountTypes = accountTypes;
	}
	public Blob getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(Blob profilePic) {
		this.profilePic = profilePic;
	}
	public AdminCreateForm(String emailId) {
		super();
		this.emailId = emailId;
	}
	public AdminCreateForm() {
		// TODO Auto-generated constructor stub
	}
	
	
	

}
