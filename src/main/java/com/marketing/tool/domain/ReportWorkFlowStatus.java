package com.marketing.tool.domain;

public enum ReportWorkFlowStatus {

	PENDING("Pending"),
	REVIEWAPPROVED("ReviewApproved"),
	REVIEWPENDING("ReviewPending"),
	PUBLISHED("Published"),
	CREATED("Created");
	
	
	private String state;
	
	private ReportWorkFlowStatus(final String state){
		this.state = state;
	}
	
	public String getState(){
		return this.state;
	}

	@Override
	public String toString(){
		return this.state;
	}

	public String getName(){
		return this.name();
	}


}
