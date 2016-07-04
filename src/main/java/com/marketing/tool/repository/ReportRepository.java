package com.marketing.tool.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import com.marketing.tool.domain.ReportForm;

public interface ReportRepository extends Repository<ReportForm,Integer>,PagingAndSortingRepository<ReportForm, Integer> {

	//T findByEmailId(String emailId);
	List<ReportForm> findAll();
	ReportForm findByReportId(Integer reportId);
	List<ReportForm> findByReportIdIn(List<Integer> reportId);
	@Query("select rep  from ReportForm rep join rep.reportStatuses ,ReportAssigners rs where rs.reportId=rep.reportId and rs.reviwerId=?1 and rs.active='Y' ")
	Page<ReportForm> findReviwerReports(int userId,Pageable pagable);
	
	
	@Query("select rep  from ReportForm rep join rep.reportStatuses rstatus ,ReportAssigners rs where rs.reportId=rep.reportId and rs.publisherId=?1 and rstatus.statusId in (?2) and rs.active='Y' ")
	Page<ReportForm> findPublisherReports(int userId,List<Integer> statusIds,Pageable pagable);
	Page<ReportForm> findAll(Pageable pagable);
	
	
	@Query("select count(distinct rep.reportId)  from ReportForm rep join rep.reportStatuses rstatus  where  rstatus.statusId=?1")
	Integer getAllPublishedReportsCount(Integer statusId);
	
	@Query("select rep  from ReportForm rep join rep.reportStatuses rstatus join rstatus.user usr where usr.id=?1 and rstatus.statusId in (?2)")
	Page<ReportForm> findAuthorReports(int userId,List<Integer> statusIds,Pageable pagable);
	
	@Query("select a from ReportForm a where profiletype = ?1 order by publishingDate desc")
	List<ReportForm> findByProfileTypeOrderByPublishingDate(String profileType,Pageable pagable);
	
}
