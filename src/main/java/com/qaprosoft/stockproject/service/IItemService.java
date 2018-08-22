package com.qaprosoft.stockproject.service;

import java.util.ArrayList;
import java.util.List;

import com.qaprosoft.stockproject.entity.Item;

public interface IItemService {
    
    List<Item> getAll();

    Item getById(Long id);

    void deleteById(Long id);

    void createNewItem(Item item);

    List<Item> getItemsByStockId(Long id);

}
