package com.marketing.tool.service;

<<<<<<< HEAD
import com.marketing.tool.domain.EditReports;
=======
>>>>>>> branch 'develop' of https://aneelkumar_ravula@bitbucket.org/aneelkumar_ravula/tool.git
import java.util.List;

import com.marketing.tool.domain.Author;
import com.marketing.tool.domain.Keyskills;

public interface AuthorService extends UserService {
	public EditReports getAuthorReports(int userId, int pageNumber, int results);

	public List<Author> findAuhtors(String country, List<Keyskills> skills);
}
