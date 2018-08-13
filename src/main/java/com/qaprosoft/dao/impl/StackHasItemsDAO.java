package com.qaprosoft.dao.impl;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.dao.IStockHasItemsDAO;
import com.qaprosoft.entity.Stock;
import com.qaprosoft.entity.StockHasItems;

public class StackHasItemsDAO implements IStockHasItemsDAO {
	
	private static Logger logger = LogManager.getLogger();

	@Override
	public ArrayList<StockHasItems> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockHasItems getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createNewStockHasItems(StockHasItems stockHasItems) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StockHasItems getStockHasItemsBtStockId(Stock stock) {
		// TODO Auto-generated method stub
		return null;
	}

}
