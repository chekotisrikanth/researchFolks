package com.marketing.tool.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.marketing.tool.domain.ReportForm;
import com.marketing.tool.domain.ReportStatus;
import com.marketing.tool.domain.ReportWorkFlowStatus;
import com.marketing.tool.domain.User;
import com.marketing.tool.domain.UserProfileType;
import com.marketing.tool.domain.ViewReport;
import com.marketing.tool.domain.ViewReports;
import com.marketing.tool.repository.ReportRepository;

@Service
@Validated
public class ReportServiceImpl implements ReportService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReportServiceImpl.class);
	
	private final ReportRepository repository;
	
	@Autowired
	private LoginUserService loginUserService;
	
	@Autowired
	ReportStatusService reportStatusService;
		
	@Inject
	public ReportServiceImpl(final ReportRepository repository) {
		this.repository = repository;
	}

	
	@Override
    @Transactional(readOnly = true)
	public List<ReportForm> getAllReports() {
		return repository.findAll();
	}
	
	@Override
	public List<ReportForm> findByReportIdIn(List<Integer> reportIds) {
		return repository.findByReportIdIn(reportIds);
	}
	
	@Override
	public ReportForm findByReportId(Integer reportFormId) {
		return repository.findByReportId(reportFormId);
	}
	
	@Override
	@Transactional
	public void updateReports(ViewReports viewReports) {
		for(ViewReport viewReport : viewReports.getViewReportsList()) {
			ReportForm report = findByReportId(new Integer(viewReport.getReportId()));
			List<String> reviewers = viewReport.getReviewerIds();
			
			for(String emailId : reviewers) {
				User user = loginUserService.findByEmailId(emailId);
				/*ReportUserProfileId reportUserProfileId = new ReportUserProfileId(user.getId(),2,viewReport.getReportId());
				ReportUserProfile  reportUserProfile = new ReportUserProfile();
				reportUserProfile.setId(reportUserProfileId);
				reportUserProfile.setReport(report);
				reportUserProfile.setUser(user);*/
				
				ReportStatus reportStatus = new ReportStatus();
				reportStatus.setReport(report);
				reportStatus.setStatus(ReportWorkFlowStatus.REVIEWPENDING.toString());
				reportStatus.setUser(user);
				reportStatus.setUserType(UserProfileType.REVIEWER.toString());
				
				/*UserProfile profile = new UserProfile();
				profile.setId(2);
				profile.setType(UserProfileType.REVIEWER.toString());
				reportUserProfile.setUserProfile(profile);*/
				reportStatusService.save(reportStatus);
			}
			
			//List<ReportUserProfile> reportUserProfiles = report.getReportUserProfiles();
			//reportUserProfiles.add(reportUserProfile);
			
		}
		//List<ReportForm> reports = reportService.findByReportIdIn(reportIds);
		
	}
	
}
