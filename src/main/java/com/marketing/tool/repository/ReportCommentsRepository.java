package com.marketing.tool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.marketing.tool.domain.ReportComments;

public interface ReportCommentsRepository extends Repository<ReportComments,Integer>  {

	ReportComments save(ReportComments reportStatus);
	
    @Query("select repComnt from ReportComments repComnt where  repComnt.reportId=?1")
	public List<ReportComments> getReportCommentsForReport(int reportId);
}
