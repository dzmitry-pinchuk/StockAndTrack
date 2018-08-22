package com.qaprosoft.stockproject.service;

import java.util.ArrayList;

import com.qaprosoft.stockproject.entity.Stock;

public interface IStockService {
    ArrayList<Stock> getAll();

    Stock getByID(Long id);

    void deleteById(Long id);

    void createNewStock(Stock stock);

    ArrayList<Stock> getAllStocks();

}
