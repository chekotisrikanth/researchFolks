package com.marketing.tool.service;

import com.marketing.tool.domain.UserProfileType;

public interface ReportAssignerService {

	public int  reportAccessForUser(Integer userId,String email,UserProfileType role);
	
	
}
