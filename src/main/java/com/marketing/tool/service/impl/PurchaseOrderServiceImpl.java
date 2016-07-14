package com.marketing.tool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.tool.domain.PurchaseOrder;
import com.marketing.tool.repository.PurchaseOrderRepository;
import com.marketing.tool.service.PurchaseOrderService;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

	@Autowired
	PurchaseOrderRepository repo;
	
	@Override
	public PurchaseOrder saveOrder(PurchaseOrder order) {
		return repo.save(order);
	}

}
