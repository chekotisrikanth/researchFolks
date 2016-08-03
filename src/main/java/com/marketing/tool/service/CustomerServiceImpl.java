package com.marketing.tool.service;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import com.marketing.tool.domain.Customer;
import com.marketing.tool.domain.CustomerAuthorFavList;
import com.marketing.tool.domain.CustomerAuthorFavListId;
import com.marketing.tool.domain.User;
import com.marketing.tool.domain.UserProfileType;
import com.marketing.tool.repository.CustomerAuthorFavListRepositroy;
import com.marketing.tool.repository.CustomerRepository;

@Service
@Validated
public class CustomerServiceImpl extends UserServiceImpl implements CustomerService {

	@Autowired
	CustomerAuthorFavListRepositroy favListRepo;
	
	@Inject
	public CustomerServiceImpl(CustomerRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public User save(@NotNull @Valid final User user) { 
		user.setAccountType(UserProfileType.USER.toString());
		return super.save(user);
	}
	
	@Override
	public CustomerAuthorFavList saveFavList(CustomerAuthorFavList favList) {
		return favListRepo.save(favList);
	}

	@Override
	public List<CustomerAuthorFavList> loadFavAnalyst(Customer customer) {
		return favListRepo.findByCustomer(customer);
	}
	
	@Override
	public CustomerAuthorFavList loadFavList(CustomerAuthorFavListId id) {
		return favListRepo.findById(id);
	}
	
	@Override
	public List<String> findReviewsByReportId(Integer reportId) {
		return favListRepo.findCustomerReviewsByReportId(reportId);
	}
	
}
