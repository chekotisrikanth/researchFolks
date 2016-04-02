package com.marketing.tool.repository;

import org.springframework.data.repository.Repository;

import com.marketing.tool.domain.ReportHistory;

public interface ReportHistoryRepository extends Repository<ReportHistory,Integer>  {

	ReportHistory save(ReportHistory reportStatus);
    	
}
