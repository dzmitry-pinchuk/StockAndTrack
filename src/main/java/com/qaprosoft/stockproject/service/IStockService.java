package com.qaprosoft.stockproject.service;

import java.util.List;

import com.qaprosoft.stockproject.entity.Stock;

public interface IStockService {
    List<Stock> getAll();

    Stock getByID(Long id);

    void deleteById(Long id);

    void createNewStock(Stock stock);

    List<Stock> getAllStocks();

}
