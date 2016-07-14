package com.marketing.tool.repository;


import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
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
