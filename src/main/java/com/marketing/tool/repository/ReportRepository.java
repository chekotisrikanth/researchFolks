package com.marketing.tool.repository;


import java.util.List;

import org.springframework.data.repository.Repository;

import com.marketing.tool.domain.ReportForm;

public interface ReportRepository extends Repository<ReportForm,Integer> {

	//T findByEmailId(String emailId);
	List<ReportForm> findAll();
	ReportForm findByReportId(Integer reportId);
	List<ReportForm> findByReportIdIn(List<Integer> reportId);
	
}
