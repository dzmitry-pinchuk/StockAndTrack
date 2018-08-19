package com.qaprosoft.stockproject.dao;

import java.util.ArrayList;

import com.qaprosoft.stockproject.entity.Stock;

public interface IStockDAO {

    ArrayList<Stock> getAll();

    Stock getById(Long id);

    void deleteById(Long id);

    void createNewStock(Stock stock);

}
