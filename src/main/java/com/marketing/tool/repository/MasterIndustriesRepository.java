package com.marketing.tool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.marketing.tool.domain.MasterIndustries;

public interface MasterIndustriesRepository extends Repository<MasterIndustries,Integer> {

	@Query("FROM MasterIndustries where masterIndustries=null)")
	List<MasterIndustries> findAllIndustries();

}
