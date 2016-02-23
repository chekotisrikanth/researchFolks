package com.marketing.tool.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.marketing.tool.domain.State;
import com.marketing.tool.domain.StockExchange;
import com.marketing.tool.repository.StockExchangeRepository;
import com.marketing.tool.service.StockExchangeService;
@Service
@Validated
public class StockExchangeServiceImpl implements StockExchangeService {
	@Autowired
	private StockExchangeRepository stockExchangeRepository;

	@Override
	public List<StockExchange> findAll() {
		// TODO Auto-generated method stub
		return stockExchangeRepository.findAll();
	}
	

	

}
