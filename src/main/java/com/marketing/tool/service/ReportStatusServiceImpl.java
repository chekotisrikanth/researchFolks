package com.marketing.tool.service;

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

	
}
