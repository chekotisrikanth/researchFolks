package com.marketing.tool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.tool.repository.ReportRepository;
import com.marketing.tool.service.PublishedReportsService;
import com.marketing.tool.utility.ReportStatusEnum;

@Service
public class PublishedReportsServiceImpl implements PublishedReportsService {
	@Autowired
	private ReportRepository reportRepository; 
	@Override
	public Integer getTotalPublishedRecordsCount() {
		
		return reportRepository.getAllPublishedReportsCount(ReportStatusEnum.PUBLISHED.getValue());
	}

}
