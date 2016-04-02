package com.marketing.tool.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.marketing.tool.domain.ReportStatus;
import com.marketing.tool.repository.ReportStatusRepository;

@Service
@Validated
public class ReportStatusServiceImpl implements ReportStatusService {

	@Autowired
	ReportStatusRepository repository;
	
	@Override
	public ReportStatus save(ReportStatus reportStatus) {
		return repository.save(reportStatus);
	}

	@Override
	public int update(int statusId,int reportId) {		
	
		//int records = repository.updateReportStatus(statusId, reportId);
		
		return repository.updateReportStatus(statusId, reportId);
	}

	@Override
	public int updateAll(int statusId, Collection<Integer> reportIds) {
		// TODO Auto-generated method stub
		return repository.updateReportStatusForAllReports(statusId, reportIds);
	}

	
}
