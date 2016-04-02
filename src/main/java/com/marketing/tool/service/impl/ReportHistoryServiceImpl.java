package com.marketing.tool.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.tool.domain.ReportHistory;
import com.marketing.tool.repository.ReportHistoryRepository;
import com.marketing.tool.service.ReportHistoryService;
@Service
public class ReportHistoryServiceImpl implements ReportHistoryService {
	@Autowired
	private ReportHistoryRepository reportHistoryRepository;
	
	@Override
	public ReportHistory save(ReportHistory reportStatus) {
		
		return reportHistoryRepository.save(reportStatus);
	}

}
