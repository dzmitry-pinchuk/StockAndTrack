package com.qaprosoft.stockproject.dao;

import java.util.ArrayList;
import java.util.List;

import com.qaprosoft.stockproject.entity.Item;

public interface IItemDAO {

    ArrayList<Item> getAll();

    Item getById(Long id);

    void deleteById(Long id);

    Item createNewItem(Item item);

    List<Item> getItemsByStockId(Long id);

}
