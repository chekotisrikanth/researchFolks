package com.marketing.tool.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.marketing.tool.domain.Author;
import com.marketing.tool.domain.AuthorReportsResp;
import com.marketing.tool.domain.master.Keyskills;

public interface AuthorService extends UserService {
	public AuthorReportsResp getAuthorReports(int userId, int pageNumber, int results);

	public List<Author> findAuhtors(String country, List<Keyskills> skills);
	public void getAuthorPublishedReports(int userId, int pageNumber, int results, AuthorReportsResp resp) ;
	public void getAuthorReportsList(int userId, int pageNumber, int results, AuthorReportsResp resp);
    public  AuthorReportsResp getPublishedRecordsCount(Integer year,Integer userId);

	Map<String, Integer> getReportsCount(String email);

	public Author findById(Integer id);

	List<Author> searchAuthors(String name,String country,Collection<String> keySkills,String exprange);
}
