package com.qaprosoft.stockproject.draft;

import java.util.ArrayList;
import java.util.List;

import com.qaprosoft.stockproject.entity.Item;

public class AlgorithmforBestLoadUsingRecursion {

	private List<Item> bestItemLoad;
	private Integer bestLoadPrice;

	private Integer calculateWeigth(List<Item> items) {
		Integer totalItemsWeigth = 0;

		for (Item item : items) {
			totalItemsWeigth += item.getWeight();
		}

		return totalItemsWeigth;
	}

	private Integer calculatePrice(List<Item> items) {
		Integer totalItemsPrice = 0;

		for (Item item : items) {
			totalItemsPrice += item.getPrice();
		}

		return totalItemsPrice;

	}

	private void checkSet(List<Item> items, Integer maxWeigth) {

		if (bestItemLoad == null) {
			if (calculateWeigth(items) <= maxWeigth) {
				bestItemLoad = items;
				bestLoadPrice = calculatePrice(items);
			}
		} else {
			if (calculateWeigth(items) <= maxWeigth && calculatePrice(items) > bestLoadPrice) {
				bestItemLoad = items;
				bestLoadPrice = calculatePrice(items);
			}
		}
	}

	public void makeAllSets(List<Item> items, Integer maxWeigth) {
		if (items.size() > 0) {
			checkSet(items, maxWeigth);
		}
		for (int i = 0; i < items.size(); i++) {
			List<Item> newSet = new ArrayList<Item>(items);
			// List<Item> newSet = new List<Item>(items);
			// newSet.RemoveAt(i);
			newSet.remove(i);
			makeAllSets(newSet, maxWeigth);
		}

	}

	// public List<Item> getBestItemLoad() {
	// return bestItemLoad;
	// }

	public Integer getBestLoadPrice() {
		return bestLoadPrice;
	}

	public List<Item> getBestItemLoad(List<Item> items, Integer maxWeigth) {
		makeAllSets(items, maxWeigth);
		return bestItemLoad;
	}

}
