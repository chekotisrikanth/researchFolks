package com.marketing.tool.service;

import java.util.List;

import com.marketing.tool.vo.ReportVo;

public interface PublishedReportsService {
	
	public Integer getTotalPublishedRecordsCount();
	
	List<ReportVo> getPublishedReportsForAuthor(int userId, int pageNumber, int results);

}
