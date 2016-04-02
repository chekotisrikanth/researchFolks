package com.marketing.tool.service;

import java.io.IOException;
import java.util.List;

import com.marketing.tool.domain.EditReports;
import com.marketing.tool.domain.ReportAssigners;
import com.marketing.tool.domain.ReportCommentsVo;
import com.marketing.tool.domain.ReportForm;
import com.marketing.tool.domain.ViewReports;
import com.marketing.tool.vo.BasicResp;

public interface ReportService {
	

	List<ReportForm> getAllReports();
	List<ReportForm> findByReportIdIn(List<Integer> reportId);
	ReportForm findByReportId(Integer reportFormId);
	void updateReports(ViewReports viewReports);
	void assignReports(List<ReportAssigners> assigners);
	EditReports getReviwerReports(int userId,Integer pageNumber,Integer results);
	BasicResp saveReportComments(ReportCommentsVo reportComments) throws IOException;
	EditReports getPublisherReports(int userId,Integer pageNumber,Integer results);
	int publishReports(List<Integer> reportIds, String userId);
	EditReports getAllReports(Integer pageNumber, Integer results);
	
}
