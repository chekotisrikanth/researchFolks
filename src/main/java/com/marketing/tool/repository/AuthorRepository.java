package com.marketing.tool.repository;

import java.util.List;

import com.marketing.tool.domain.Author;
import com.marketing.tool.domain.Keyskills;




public interface AuthorRepository extends UserRepository<Author> {

	List<Author> findByCountryAndKeyskillsIn(String country,List<Keyskills> skills);
	List<Author> findByKeyskillsIn(List<Keyskills> skills);
}
