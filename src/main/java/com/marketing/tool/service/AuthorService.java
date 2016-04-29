package com.marketing.tool.service;

import java.util.List;

import com.marketing.tool.domain.Author;
import com.marketing.tool.domain.Keyskills;

public interface AuthorService extends UserService {

	public List<Author> findAuhtors(String country, List<Keyskills> skills);
}
