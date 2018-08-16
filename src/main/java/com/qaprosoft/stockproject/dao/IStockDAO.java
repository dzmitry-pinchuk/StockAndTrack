package com.qaprosoft.dao;

import java.util.ArrayList;

import com.qaprosoft.entity.Stock;

public interface IStockDAO {
	
	public ArrayList<Stock> getAll();
	
	public Stock getById(Long id);
	
	public void deleteById(Long id);
	
	public void createNewStock(Stock stock);

}
