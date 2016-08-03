package com.marketing.tool.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import com.marketing.tool.domain.Customer;
import com.marketing.tool.domain.CustomerAuthorFavList;
import com.marketing.tool.domain.CustomerAuthorFavListId;

public interface CustomerAuthorFavListRepositroy extends Repository<CustomerAuthorFavList, CustomerAuthorFavListId> {
	
	//findDistinctByAuthorAndByCustomer
	//findByCustomer
	CustomerAuthorFavList save(CustomerAuthorFavList favList);
	List<CustomerAuthorFavList> findByCustomer(Customer customer);
	CustomerAuthorFavList findById(CustomerAuthorFavListId id); 
	
	@Query(" select c.review From CustomerAuthorFavList c where c.id.reportid=?")
	List<String> findCustomerReviewsByReportId(Integer reportId);

}
