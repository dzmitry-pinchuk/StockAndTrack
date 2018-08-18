package com.qaprosoft.stockproject.service;

import com.qaprosoft.stockproject.dao.jdbc.impl.StockDAO;
import com.qaprosoft.stockproject.entity.Stock;

public class StockHasItemService {
	
	StockDAO sDAO = new StockDAO();
	
	
	public Stock getAll() {
		sDAO.getAll();
		
		return null;
	}

}
