package com.marketing.tool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.tool.domain.UserProfileType;
import com.marketing.tool.exception.ReportAccessExpetion;
import com.marketing.tool.repository.ReportAssignerRepository;
import com.marketing.tool.repository.ReportCommentsRepository;
import com.marketing.tool.repository.ReportStatusRepository;
import com.marketing.tool.service.ReportAssignerService;
import com.marketing.tool.utility.SharedConstants;
@Service
public class ReportAssignerServiceImpl implements ReportAssignerService {
	@Autowired
	public ReportAssignerRepository reportAssignerRepository;
	@Autowired	
	public ReportStatusRepository reportStatusRepository;
	
	@Autowired	
	public ReportCommentsRepository reportCommentsRepository;
	
	@Override
	public Integer reportAccessForUser(Integer reportId, String email, UserProfileType role,String type) {
		Integer userId = null;
		switch (role) {
		case REVIEWER:
			if(SharedConstants.COMMENTS.equals(type)) {
				userId = reportCommentsRepository.getAuthorIdForComments(reportId, email);
			} else {
				userId = reportAssignerRepository.getUserIdForReport(reportId, email);
			}
			
			break;
        case PUBLISHER:
        	userId = reportAssignerRepository.getUserIdForReportForPublisher(reportId, email);
			break;
        case AUTHOR:
        	userId = reportStatusRepository.findUserIdByReportId(reportId, email);
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
