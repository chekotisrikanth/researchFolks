package com.marketing.tool.repository;

import org.springframework.data.repository.Repository;

import com.marketing.tool.domain.ReportStatus;

public interface ReportStatusRepository extends Repository<ReportStatus,Integer>  {

	ReportStatus save(ReportStatus reportStatus);
	
}
