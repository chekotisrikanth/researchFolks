package com.marketing.tool.repository;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.marketing.tool.domain.ReportStatus;

public interface ReportStatusRepository extends Repository<ReportStatus,Integer>  {

	ReportStatus save(ReportStatus reportStatus);
    //@Transactional
    //@Query("update ReportStatus rt set rt.statusId=?1 , rt.statusId=?1 ")
	//public int  updateReportStatus(int reportId, int statusId,int  cycleId) ;

	@Modifying
	@Transactional
    @Query("update ReportStatus rt set rt.statusId=?1  where  rt.report.reportId=?2")
    public int  updateReportStatus( int statusId,int reportId) ;
	
	
	@Modifying
	@Transactional
    @Query("update ReportStatus rt set rt.statusId=?1 where  rt.report.reportId in(?2)")
    public int  updateReportStatusForAllReports( int statusId,Collection<Integer> reportIds) ;
	
    @Query("select usr.id  from ReportStatus rt join rt.user usr where  rt.report.reportId = ?1  and usr.emailId=?2)")
	public int findUserIdByReportId(int reportId,String email);
    
    @Query("select rt.statusId,count(rt.statusId)  from ReportStatus rt join rt.user usr where   usr.emailId=?1 group by rt.statusId)")
   	public List<Object[]> reportsSummary(String email);
    
	
}
