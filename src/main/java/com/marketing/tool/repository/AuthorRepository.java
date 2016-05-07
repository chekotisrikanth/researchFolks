package com.marketing.tool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.marketing.tool.domain.Author;
import com.marketing.tool.domain.Keyskills;




public interface AuthorRepository extends UserRepository<Author> {

	List<Author> findByCountryAndKeyskillsIn(String country,List<Keyskills> skills);
	List<Author> findByKeyskillsIn(List<Keyskills> skills);
	
	//@Query("select month(rep.publishingDate)  from ReportForm rep join rep.reportStatuses rstatus join rstatus.user usr where usr.id=?1 and rstatus.statusId in (?2)")
	//List<Object[]> findAuthorReportsByMonthWise(int userId,List<Integer> statusIds);
}
