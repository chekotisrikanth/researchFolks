package com.marketing.tool.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import com.marketing.tool.domain.Country;
import com.marketing.tool.domain.StockExchange;

public interface StockExchangeRepository extends Repository<StockExchange,Integer> {

	List<StockExchange> findAll();
	
}
