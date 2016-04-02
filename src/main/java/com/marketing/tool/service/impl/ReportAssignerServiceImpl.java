package com.marketing.tool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.tool.domain.UserProfileType;
import com.marketing.tool.exception.ReportAccessExpetion;
import com.marketing.tool.repository.ReportAssignerRepository;
import com.marketing.tool.service.ReportAssignerService;
@Service
public class ReportAssignerServiceImpl implements ReportAssignerService {
	@Autowired
	public ReportAssignerRepository reportAssignerRepository;
	
	@Override
	public int reportAccessForUser(Integer reportId, String email, UserProfileType role) {
		Integer userId = null;
		switch (role) {
		case REVIEWER:
			userId = reportAssignerRepository.getUserIdForReport(reportId, email);
			break;
        case PUBLISHER:
        	userId = reportAssignerRepository.getUserIdForReportForPublisher(reportId, email);
			break;
        case AUTHOR:
        	//userId = reportAssignerRepository.getUserIdForReportForPublisher(reportId, email);
			break;
		default:
			break;
		}
		if(userId == null) {
			throw new ReportAccessExpetion("Don't have access to Download Report");
		}
		return userId;
	}

}
