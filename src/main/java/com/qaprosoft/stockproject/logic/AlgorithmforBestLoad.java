package com.qaprosoft.stockproject.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.stockproject.entity.Item;
import com.qaprosoft.stockproject.entity.transport.AbstractTransport;

public class AlgorithmforBestLoad {

    private static Logger logger = LogManager.getLogger();

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
