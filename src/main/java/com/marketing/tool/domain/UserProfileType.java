package com.marketing.tool.domain;

public enum UserProfileType {
	USER("USER"),
	PUBLISHER("PUBLISHER"),
	ADMIN("ADMIN"),
	REVIEWER("REVIEWER"),
	AUTHOR("AUTHOR");
	
	String userProfileType;
	
	private UserProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}
