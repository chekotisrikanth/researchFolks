package com.marketing.tool.service;

import com.marketing.tool.domain.UserProfileType;

public interface ReportAssignerService {

	public Integer  reportAccessForUser(Integer userId,String email,UserProfileType role,String type);
	
	
}
