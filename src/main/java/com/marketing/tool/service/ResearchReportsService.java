package com.marketing.tool.service;

import java.util.List;

import com.marketing.tool.domain.EditReports;
import com.marketing.tool.domain.ReportForm;
import com.marketing.tool.vo.ReportVo;
import com.marketing.tool.vo.SearchCriteria;

public interface ResearchReportsService {
	
	//public List<ReportVo> getPublishedReportsFromSearchCriteria(SearchCriteria searchCriteria);

	EditReports getPublishedReportsFromSearchCriteria(SearchCriteria searchCriteria, int pageNumber, int results);
	
}
