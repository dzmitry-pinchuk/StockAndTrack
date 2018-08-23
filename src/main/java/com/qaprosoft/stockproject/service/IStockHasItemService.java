package com.qaprosoft.stockproject.service;

import java.util.List;

import com.qaprosoft.stockproject.entity.StockHasItem;

public interface IStockHasItemService {

	List<StockHasItem> getItemAndQuantityByStockId(Long id);

	StockHasItem insertNewItemInStock(Long stockID, StockHasItem shi);

	void updateItemInStock(Long stockID, Long itemId, Integer newCount);

	void deleteItemInStock(StockHasItem shi);

	void deleteItemByStockIdAndItemId(Long stockId, Long itemId);

	Integer getQuantityByStockAndItem(Long itemId, Long stockId);

	void insertNewItemInStockByStockItemAndNumber(Long stockID, Long itemId, Integer quantity);

}
