package com.marketing.tool.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import com.marketing.tool.domain.ReportForm;

public interface ReportSearchRepository extends Repository<ReportForm,Integer>,PagingAndSortingRepository<ReportForm, Integer>,JpaSpecificationExecutor<ReportForm> {

	Page<ReportForm> findAll(Specification<ReportForm> spec,Pageable page);
}
