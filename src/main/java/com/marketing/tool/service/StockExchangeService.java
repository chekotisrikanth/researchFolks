package com.marketing.tool.service;

import java.util.List;

import com.marketing.tool.domain.State;
import com.marketing.tool.domain.StockExchange;
import com.marketing.tool.domain.master.Country;

public interface StockExchangeService {
	
	
	List<StockExchange> findAll();

}
