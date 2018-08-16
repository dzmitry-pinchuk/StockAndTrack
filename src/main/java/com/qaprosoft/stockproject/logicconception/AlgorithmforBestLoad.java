package com.qaprosoft.stockproject.logicconception;

import java.util.ArrayList;
import java.util.List;

import com.qaprosoft.stockproject.entity.Item;
import com.qaprosoft.stockproject.entity.transport.AbstractTransport;

public class AlgorithmforBestLoad {

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

    private void checkSet(List<Item> items, AbstractTransport transport) {

	if (bestItemLoad == null) {
	    if (calculateWeigth(items) <= transport.getMaxCarryingCapacity()) {
		bestItemLoad = items;
		bestLoadPrice = calculatePrice(items);
	    }
	} else {
	    if (calculateWeigth(items) <= transport.getMaxCarryingCapacity() && calculatePrice(items) > bestLoadPrice) {
		bestItemLoad = items;
		bestLoadPrice = calculatePrice(items);
	    }
	}
    }

    public void makeAllSets(List<Item> items, AbstractTransport transport) {
	if (items.size() > 0) {
	    checkSet(items, transport);
	}
	for (int i = 0; i < items.size(); i++) {
	    List<Item> newSet = new ArrayList<Item>(items);
	    // List<Item> newSet = new List<Item>(items);
	    // newSet.RemoveAt(i);
	    newSet.remove(i);
	    makeAllSets(newSet, transport);
	}

    }

    public List<Item> getBestItemLoad() {
	return bestItemLoad;
    }

    public Integer getBestLoadPrice() {
	return bestLoadPrice;
    }
    
    
    public  List<Item> get

}

//
// int knapsack(int weights[], int costs[], int needed) {
// int n = weights.length;
// int dp[][] = new int[needed + 1][n + 1];
// for (int j = 1; j <= n; j++) {
// for (int w = 1; w <= needed; w++) {
// if (weights[j - 1] <= w) {
// dp[w][j] = Math.max(dp[w][j - 1], dp[w - weights[j - 1]][j - 1] + costs[j -
// 1]);
// } else {
// dp[w][j] = dp[w][j - 1];
// }
// }
// }
// return dp[needed][n];
// }
//
