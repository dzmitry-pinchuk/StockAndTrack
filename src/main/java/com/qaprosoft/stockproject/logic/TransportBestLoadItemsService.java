package com.qaprosoft.stockproject.logic;

import java.util.List;

import org.apache.logging.log4j.Level;

import com.qaprosoft.stockproject.entity.Item;
import com.qaprosoft.stockproject.entity.Report;
import com.qaprosoft.stockproject.entity.TypeOfTransport;
import com.qaprosoft.stockproject.entity.transport.AbstractTransport;
import com.qaprosoft.stockproject.service.ItemService;
import com.qaprosoft.stockproject.service.StockHasItemService;
import com.qaprosoft.stockproject.service.StockService;
import com.qaprosoft.stockproject.service.TrackService;

public class TransportBestLoadItemsService {

	private ItemService itemService;

	// what if TRAIN what to do??????????????
	private TrackService trackService;
	private StockService stockService;
	// private StockHasItemDAO stockHasItemDAO;
	private StockHasItemService stockHasItemService;

	public TransportBestLoadItemsService() {
		this.itemService = new ItemService();
		this.trackService = new TrackService();
		this.stockHasItemService = new StockHasItemService();
		this.stockService = new StockService();

	}

//	public boolean checkTrasportForStock(Long fromIdStock, Long toIdStock, Long idTrasport) {
//
//		TypeOfTransport typeOfTransport = trackService.getById(idTrasport).getType();
//
//		List<TypeOfTransport> list1 = stockService.getByID(fromIdStock).getTypes();
//		List<TypeOfTransport> list2 = stockService.getByID(toIdStock).getTypes();
//
//		return list1.contains(typeOfTransport) && list2.contains(typeOfTransport);
//	}
	
	public boolean checkTrasportForStock(Report report) { //!!!!!!!!!!!!!!
		TypeOfTransport typeOfTransport = report.getTransport().getType();
		List<TypeOfTransport> list1 = report.getStock1().getTypes();
		List<TypeOfTransport> list2 = report.getStock2().getTypes();
		return list1.contains(typeOfTransport) && list2.contains(typeOfTransport);
	}

	public List<Item> transportItems(Report report) { //зависает
		List<Item> items = itemService.getItemsByStockId(report.getStock1().getId());
		Integer maxWeigtht =report.getTransport().getMaxCarryingCapacity();
		AlgorithmforBestLoad algorithmforBestLoad = new AlgorithmforBestLoad();
		System.out.println("3333 ");
		System.out.println(items);
		System.out.println("weight "+ maxWeigtht);
		algorithmforBestLoad.makeAllSets(items, maxWeigtht);
//		List<Item> bestLoadList = algorithmforBestLoad.getBestItemLoad(items, maxWeigtht);
		List<Item> bestLoadList = algorithmforBestLoad.getBestItemLoad();
		System.out.println("121212");
		return bestLoadList;
//		for (Item item : bestLoadList) {
//			// update in from
//			Integer fromCount = stockHasItemService.getQuantityByStockAndItem(item.getId(), fromIdStock);
//			if (fromCount == 1) {
//				stockHasItemService.deleteItemByStockIdAndItemId(fromIdStock, item.getId());
//				// stockHasItemDAO.deleteItemInStock(shi); deleteb by stock and item id
//			} else if (fromCount > 1) {
//				stockHasItemService.updateItemInStock(fromIdStock, item.getId(), fromCount - 1);
//			}
//			// update in to
//			Integer toCount = stockHasItemService.getQuantityByStockAndItem(item.getId(), toIdStock);
//			if (toCount == null) {
//				stockHasItemService.insertNewItemInStockByStockItemAndNumber(toIdStock, item.getId(), 1);
//			} else {
//				stockHasItemService.updateItemInStock(toIdStock, item.getId(), toCount + 1);
//			}
//		}

	}
	
	
	
	
	
//	public void transportItems(Long fromIdStock, Long toIdStock, Long idTrasport) {
//		List<Item> items = itemService.getItemsByStockId(fromIdStock);
//		Integer maxWeigtht = trackService.getById(idTrasport).getMaxCarryingCapacity();
//		AlgorithmforBestLoad algorithmforBestLoad = new AlgorithmforBestLoad();
//		List<Item> bestLoadList = algorithmforBestLoad.getBestItemLoad(items, maxWeigtht);
//
//		for (Item item : bestLoadList) {
//			// update in from
//			Integer fromCount = stockHasItemService.getQuantityByStockAndItem(item.getId(), fromIdStock);
//			if (fromCount == 1) {
//				stockHasItemService.deleteItemByStockIdAndItemId(fromIdStock, item.getId());
//				// stockHasItemDAO.deleteItemInStock(shi); deleteb by stock and item id
//			} else if (fromCount > 1) {
//				stockHasItemService.updateItemInStock(fromIdStock, item.getId(), fromCount - 1);
//			}
//			// update in to
//			Integer toCount = stockHasItemService.getQuantityByStockAndItem(item.getId(), toIdStock);
//			if (toCount == null) {
//				stockHasItemService.insertNewItemInStockByStockItemAndNumber(toIdStock, item.getId(), 1);
//			} else {
//				stockHasItemService.updateItemInStock(toIdStock, item.getId(), toCount + 1);
//			}
//		}
//
//	}

}
