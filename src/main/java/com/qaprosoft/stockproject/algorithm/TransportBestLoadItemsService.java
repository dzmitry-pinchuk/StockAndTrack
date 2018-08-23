package com.qaprosoft.stockproject.algorithm;

import java.util.List;

import com.qaprosoft.stockproject.entity.Item;
import com.qaprosoft.stockproject.entity.Report;
import com.qaprosoft.stockproject.entity.TypeOfTransport;
import com.qaprosoft.stockproject.service.impl.ItemService;


public class TransportBestLoadItemsService {

	private ItemService itemService = new ItemService();

	public boolean checkTrasportForStock(Report report) {
		TypeOfTransport typeOfTransport = report.getTransport().getType();
		List<TypeOfTransport> list1 = report.getStockFrom().getTypes();
		List<TypeOfTransport> list2 = report.getStockTo().getTypes();
		return list1.contains(typeOfTransport) && list2.contains(typeOfTransport);
	}

	public List<Item> transportItems(Report report) {
		List<Item> items = itemService.getItemsByStockId(report.getStockFrom().getId());
		Integer maxWeigtht = report.getTransport().getMaxCarryingCapacity();
		AlgorithmforBestLoad algorithmforBestLoad = new AlgorithmforBestLoad();
		List<Item> bestLoadList = algorithmforBestLoad.getBestItemLoad(items, maxWeigtht);
		return bestLoadList;
	}

}
