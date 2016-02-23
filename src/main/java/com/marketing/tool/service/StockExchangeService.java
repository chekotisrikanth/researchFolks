package com.marketing.tool.service;

import java.util.List;

import com.marketing.tool.domain.Country;
import com.marketing.tool.domain.State;
import com.marketing.tool.domain.StockExchange;

public interface StockExchangeService {
	
	
	List<StockExchange> findAll();

}
