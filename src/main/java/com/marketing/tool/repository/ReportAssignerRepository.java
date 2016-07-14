package com.marketing.tool.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.marketing.tool.domain.ReportAssigners;

public interface ReportAssignerRepository extends CrudRepository<ReportAssigners,Integer>,PagingAndSortingRepository<ReportAssigners, Integer>  {

	//ReportAssigners save(ReportAssigners reportAssigners);
	//List<ReportAssigners> save(List<ReportAssigners> reportAssigners);
	@Query("select user.id from ReportAssigners ras, User user where ras.reportId=?1 and user.emailId=?2 and  user.id=ras.reviwerId and ras.active='Y' group by ras.reviwerId,ras.reportId  ")
	Integer  getUserIdForReport(int reportId, String email);
	
	
	
	
	@Query("select user.id from ReportAssigners ras, User user where ras.reportId=?1 and user.emailId=?2 and  user.id=ras.publisherId and ras.active='Y' group by ras.reviwerId,ras.reportId  ")
	Integer  getUserIdForReportForPublisher(int reportId, String email);
	
	@Query("select ras from ReportAssigners ras where ras.reportId in(?1) and ras.active='Y'")
	List<ReportAssigners> getAssignersForReports(Collection<Integer> reportIds);
	
	
	
	
}
