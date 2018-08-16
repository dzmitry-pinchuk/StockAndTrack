package com.qaprosoft.stockproject.dao;

import java.util.ArrayList;

import com.qaprosoft.stockproject.entity.Stock;

public interface IStockDAO {
	
	public ArrayList<Stock> getAll();
	
	public Stock getById(Long id);
	
	public void deleteById(Long id);
	
	public void createNewStock(Stock stock);

}
