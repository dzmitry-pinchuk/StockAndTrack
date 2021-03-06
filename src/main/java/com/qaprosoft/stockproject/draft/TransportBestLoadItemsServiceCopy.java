package com.qaprosoft.stockproject.draft;

import java.util.List;

import com.qaprosoft.stockproject.entity.Item;
import com.qaprosoft.stockproject.entity.TypeOfTransport;
import com.qaprosoft.stockproject.service.impl.ItemService;
import com.qaprosoft.stockproject.service.impl.StockHasItemService;
import com.qaprosoft.stockproject.service.impl.StockService;
import com.qaprosoft.stockproject.service.impl.TrackService;

public class TransportBestLoadItemsServiceCopy {

	private ItemService itemService;
// for Transport
	private TrackService trackService;
	private StockService stockService;
	// private StockHasItemDAO stockHasItemDAO;
	private StockHasItemService stockHasItemService;

	public TransportBestLoadItemsServiceCopy() {
		this.itemService = new ItemService();
		this.trackService = new TrackService();
		this.stockHasItemService = new StockHasItemService();
		this.stockService = new StockService();

	}

	public boolean checkTrasportForStock(Long fromIdStock, Long toIdStock, Long idTrasport) {

		TypeOfTransport typeOfTransport = trackService.getById(idTrasport).getType();
		List<TypeOfTransport> list1 = stockService.getById(fromIdStock).getTypes();
		List<TypeOfTransport> list2 = stockService.getById(toIdStock).getTypes();
		return list1.contains(typeOfTransport) && list2.contains(typeOfTransport);

	}

	public void trasportItems(Long fromIdStock, Long toIdStock, Long idTrasport) {
		List<Item> items = itemService.getItemsByStockId(fromIdStock);
		Integer maxWeight = trackService.getById(idTrasport).getMaxCarryingCapacity();
		AlgorithmforBestLoad algorithmforBestLoad = new AlgorithmforBestLoad();
		List<Item> bestLoadList = algorithmforBestLoad.getBestItemLoad(items, maxWeight);

		for (Item item : bestLoadList) {
			// update in fromStock
			Integer fromCount = stockHasItemService.getQuantityByStockAndItem(item.getId(), fromIdStock);
			if (fromCount == 1) {
				stockHasItemService.deleteItemByStockIdAndItemId(fromIdStock, item.getId());
				// stockHasItemDAO.deleteItemInStock(shi); delete by stock and item id
			} else if (fromCount > 1) {
				stockHasItemService.updateItemInStock(fromIdStock, item.getId(), fromCount - 1);
			}
			// update in toStock
			Integer toCount = stockHasItemService.getQuantityByStockAndItem(item.getId(), toIdStock);
			if (toCount == null) {
				stockHasItemService.insertNewItemInStockByStockItemAndNumber(toIdStock, item.getId(), 1);
			} else {
				stockHasItemService.updateItemInStock(toIdStock, item.getId(), toCount + 1);
			}
		}

	}

}
