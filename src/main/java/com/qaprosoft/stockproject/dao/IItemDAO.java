package com.qaprosoft.stockproject.dao;

import java.util.ArrayList;
import java.util.List;

import com.qaprosoft.stockproject.entity.Item;
import com.qaprosoft.stockproject.service.IDefaultService;

public interface IItemDAO {

    ArrayList<Item> getAll();

    Item getById(Long id);

    void deleteById(Long id);

    Item add(Item item);

    List<Item> getItemsByStockId(Long id);

}
