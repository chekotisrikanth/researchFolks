package com.marketing.tool.service;

import java.text.ParseException;

import com.marketing.tool.vo.ReportCommentsHistoryList;

public interface ReportCommentsService {
	
	ReportCommentsHistoryList getReportCommentsForReport(int reportId);
	void updateOrInsert(Integer reportId,Integer  emailId);
	void insertReportCommentsAlert(Integer reportId, Integer  emailId) throws ParseException;
	void updateReportCommentsAlert(Integer reportId, Integer  emailId) throws ParseException ;
	
}
