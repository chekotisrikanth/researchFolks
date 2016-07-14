package com.marketing.tool.repository;


import java.util.List;

import org.springframework.data.repository.Repository;

import com.marketing.tool.domain.PurchaseOrder;

public interface PurchaseOrderRepository extends Repository<PurchaseOrder, Integer> {

	//PurchaseOrder findByEmailId(String emailId);
	PurchaseOrder save(PurchaseOrder order);
	List<PurchaseOrder> findAll();
	//T findBYEmailIdAndPassword();
	
}
