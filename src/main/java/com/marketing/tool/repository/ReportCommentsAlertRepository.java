package com.marketing.tool.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.Repository;

import com.marketing.tool.domain.ReportCommentsAlert;

public interface ReportCommentsAlertRepository extends Repository<ReportCommentsAlert,Integer>,PagingAndSortingRepository<ReportCommentsAlert, Integer>,JpaSpecificationExecutor<ReportCommentsAlert> {
	
	@Query("select rep from ReportCommentsAlert rep where rep.reportId =?1 and rep.userId=?2 order by rep.reportId asc")
	ReportCommentsAlert findByReportIdAndUserId(int reportId,Integer emailId);
	
	@Query("select rep from ReportCommentsAlert rep where rep.userId=?1 order by rep.reportId asc")
	List<ReportCommentsAlert> findByUserId(Integer emailId);
	
	@Modifying
	@Query("update ReportCommentsAlert rep set rep.lastSeenDate=?1 where rep.userId=?2 and rep.reportId=?3 ")
	int update(Date lastSeenDate,Integer emailId,Integer reportId);
}
