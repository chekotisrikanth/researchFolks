package com.marketing.tool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.tool.repository.ReportRepository;
import com.marketing.tool.service.PublishedReportsService;
import com.marketing.tool.utility.ReportStatusEnum;
import com.marketing.tool.vo.ReportVo;

@Service
public class PublishedReportsServiceImpl implements PublishedReportsService {
	@Autowired
	private ReportRepository reportRepository; 
	@Override
	public Integer getTotalPublishedRecordsCount() {
		
		return reportRepository.getAllPublishedReportsCount(ReportStatusEnum.PUBLISHED.getValue());
	}
	@Override
	public List<ReportVo> getPublishedReportsForAuthor(int userId, int pageNumber, int results) {
		// TODO Auto-generated method stub
		return null;
	}

}
