package com.marketing.tool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.marketing.tool.domain.ReportComments;

public interface ReportCommentsRepository extends Repository<ReportComments,Integer>  {

	ReportComments save(ReportComments reportStatus);
	
    @Query("select repComnt from ReportComments repComnt where  repComnt.reportId=?1 order by insertedDate desc")
	public List<ReportComments> getReportCommentsForReport(int reportId);
    
    @Query("select user.id from ReportComments ras, User user where ras.id=?1 and user.emailId=?2 and  user.id=ras.userId ")
	Integer  getUserIdForReportComments(int reportId, String email);
    
    @Query("select repComnt.filePath from ReportComments repComnt where  repComnt.id=?1 order by insertedDate desc")
   	public String getReportCommentsFilePath(int commentsId);
    
    
    @Query("select ras.reviwerId from ReportComments recom, ReportAssigners ras, User user  where recom.id=?1 and user.emailId=?2 and  ras.reportId=ras.reportId and user.id=ras.reviwerId and ras.active='Y'")
	Integer  getAuthorIdForComments(int reportId, String email);
}
