package com.qaprosoft.stockproject.dao;

import java.util.List;

import com.qaprosoft.stockproject.entity.Item;

public interface IItemDAO extends IDefaultDAO<Long, Item> {

    List<Item> getItemsByStockId(Long id);

}
