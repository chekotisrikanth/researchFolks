package com.marketing.tool.service;

import java.util.Collection;
import java.util.List;

import com.marketing.tool.domain.ReportStatus;

public interface ReportStatusService {

	ReportStatus save(ReportStatus reportStatus);
	
	
	//ReportStatus update(ReportStatus reportStatus);
	
	int update(int statusId, int reportId);
	int updateAll(int statusId, Collection<Integer> reportIds);
	
}
