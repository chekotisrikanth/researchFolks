package com.marketing.tool.service.impl;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.tool.domain.ReportComments;
import com.marketing.tool.domain.ReportCommentsAlert;
import com.marketing.tool.domain.User;
import com.marketing.tool.reponse.builder.ReportCmntsBuilder;
import com.marketing.tool.repository.ReportCommentsAlertRepository;
import com.marketing.tool.repository.ReportCommentsRepository;
import com.marketing.tool.repository.UserRepository;
import com.marketing.tool.service.ReportCommentsService;
import com.marketing.tool.utility.DateUtills;
import com.marketing.tool.vo.ReportCommentsHistoryList;
@Service("reportCommentsService")
public class ReportCommentsServiceImpl implements ReportCommentsService {

	@Autowired
	private ReportCommentsRepository reportsCommenstRepositopry;
	
	@Autowired
	private ReportCommentsAlertRepository reportCommentsAlertRepository;
	
	
	@Override
	public ReportCommentsHistoryList getReportCommentsForReport(int reportId) {
		
		List<ReportComments> commentsList = reportsCommenstRepositopry.getReportCommentsForReport(reportId);
		ReportCommentsHistoryList rep = ReportCmntsBuilder.buildRePortComments(commentsList);
		if(rep != null) {
			rep.setReportId(reportId);
		}
		return rep;
	}



	@Override
	public void insertReportCommentsAlert(Integer reportId, Integer emailId) throws ParseException {		
		
		//load user
		ReportCommentsAlert alert = new ReportCommentsAlert();
		alert.setReportId(reportId);
		alert.setUserId(emailId);
	    alert.setLastSeenDate(DateUtills.getCurrentDate());
		
		reportCommentsAlertRepository.save(alert);
		
	}
	
	
	public  void updateReportCommentsAlert(Integer reportId, Integer emailId) throws ParseException {
		int cnt = reportCommentsAlertRepository.update(DateUtills.getCurrentDate(), emailId, reportId);
		
	}



	@Override
	public void updateOrInsert(Integer reportId, Integer emailId) {
		ReportCommentsAlert alert = null;
		try {
			alert = reportCommentsAlertRepository.findByReportIdAndUserId(reportId, emailId);
			if(alert == null) {
	
			insertReportCommentsAlert(reportId, emailId);
			} else {
				alert.setLastSeenDate(DateUtills.getCurrentDate());
				reportCommentsAlertRepository.save(alert);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}
