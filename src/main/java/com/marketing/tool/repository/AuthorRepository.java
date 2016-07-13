package com.marketing.tool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.marketing.tool.domain.Author;
import com.marketing.tool.domain.Keyskills;




public interface AuthorRepository extends UserRepository<Author> {

	List<Author> findByCountryAndKeyskillsIn(String country,List<Keyskills> skills);
	List<Author> findByKeyskillsIn(List<Keyskills> skills);
	Author findById(Integer id);
	
	@Query("select count(distinct rep.reportId),month(rep.publishedDate) as monthCnt,year(rep.publishedDate)   from ReportForm rep join rep.reportStatuses rstatus join rstatus.user usr where usr.id=?1 and rstatus.statusId in (?2) group by rstatus.statusId,rep.publishedDate ")
	List<Object[]> findAuthorReportsByMonthWise(int userId,List<Integer> statusIds);
	
	@Query("select count(distinct rep.reportId),month(rep.publishedDate) as monthCnt,year(rep.publishedDate),rstatus.statusId   from ReportForm rep join rep.reportStatuses rstatus join rstatus.user usr where usr.id=?1 and year(rep.publishedDate)=?2  group by rstatus.statusId,rep.publishedDate ")
	List<Object[]> findAuthorReportsByMonthWise(int userId,int year);
}
