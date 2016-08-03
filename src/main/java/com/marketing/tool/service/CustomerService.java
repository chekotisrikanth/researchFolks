package com.marketing.tool.service;

import java.util.List;

import com.marketing.tool.domain.Customer;
import com.marketing.tool.domain.CustomerAuthorFavList;
import com.marketing.tool.domain.CustomerAuthorFavListId;

public interface CustomerService extends UserService {

	public CustomerAuthorFavList saveFavList(CustomerAuthorFavList favList);
	
	List<CustomerAuthorFavList> loadFavAnalyst(Customer customer) ;

	CustomerAuthorFavList loadFavList(CustomerAuthorFavListId id);

	List<String> findReviewsByReportId(Integer reportId);
	
		
}
