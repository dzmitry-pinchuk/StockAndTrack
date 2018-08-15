package com.qaprosoft.dao.jdbc.impl;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.dao.IStockDAO;
import com.qaprosoft.entity.Stock;

public class StockDAO implements IStockDAO{

	private static Logger logger = LogManager.getLogger();
	
	@Override
	public ArrayList<Stock> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stock getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createNewStock(Stock stock) {
		// TODO Auto-generated method stub
		
	}
	

}
