package com.marketing.tool.service;

import java.util.List;

import com.marketing.tool.domain.Author;
import com.marketing.tool.domain.AuthorReportsResp;
import com.marketing.tool.domain.Keyskills;

public interface AuthorService extends UserService {
	public AuthorReportsResp getAuthorReports(int userId, int pageNumber, int results);

	public List<Author> findAuhtors(String country, List<Keyskills> skills);
	public void getAuthorPublishedReports(int userId, int pageNumber, int results, AuthorReportsResp resp) ;
	public void getAuthorReportsList(int userId, int pageNumber, int results, AuthorReportsResp resp);
	public Author findById(Integer id);
}
