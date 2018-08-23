package com.qaprosoft.stockproject.service;

import java.util.List;

import com.qaprosoft.stockproject.entity.Item;

public interface IItemService extends IDefaultService<Long, Item> {

	List<Item> getItemsByStockId(Long id);

}
