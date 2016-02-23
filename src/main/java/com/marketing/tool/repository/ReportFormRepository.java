package com.marketing.tool.repository;


import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.marketing.tool.domain.ReportForm;

@NoRepositoryBean
public interface ReportFormRepository<T extends ReportForm> extends Repository<T , Integer> {

	//T findByEmailId(String emailId);
	T save(ReportForm reportForm);
	List<T> findAll();
	ReportForm findByReportId(Integer reportId);
	
}
