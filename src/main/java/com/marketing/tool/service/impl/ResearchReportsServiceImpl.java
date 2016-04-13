package com.marketing.tool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.marketing.tool.domain.EditReports;
import com.marketing.tool.domain.ReportForm;
import com.marketing.tool.reponse.builder.ReportsSearchResponseBuilder;
import com.marketing.tool.repository.ReportSearchRepository;
import com.marketing.tool.service.ResearchReportsService;
import com.marketing.tool.utility.ReportSearchFilter;
import com.marketing.tool.utility.ReportStatusEnum;
import com.marketing.tool.vo.SearchCriteria;
@Service
public class ResearchReportsServiceImpl implements ResearchReportsService {

	@Autowired
	private ReportSearchRepository reportSearchRepository;
	
	

	@Override
	public EditReports getPublishedReportsFromSearchCriteria(SearchCriteria searchCriteria,int pageNumber,int results) {
		final PageRequest page = new PageRequest(pageNumber, results);
		searchCriteria.setStatusId(ReportStatusEnum.PUBLISHED.getValue());
		Page<ReportForm> form = reportSearchRepository.findAll(ReportSearchFilter.findByCriteriaForindustry(searchCriteria),page);
		EditReports editreports = new EditReports();
        editreports.setReportsList(ReportsSearchResponseBuilder.buildReports(form.getContent()));
        editreports.setTotalPages(form.getTotalPages());
		return editreports;
	}
	
}
