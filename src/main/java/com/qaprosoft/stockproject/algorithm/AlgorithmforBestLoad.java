package com.qaprosoft.stockproject.algorithm;

import java.util.ArrayList;
import java.util.List;

import com.qaprosoft.stockproject.entity.Item;

public final class AlgorithmforBestLoad {

	private static List<Item> bestItemsLoadList;
	private static int solutionWeight;
	private static int bestLoadPrice;
	private static boolean calculated;

	public static List<Item> getBestItemLoad(List<Item> itemList, Integer maxWeight) {
		bestItemsLoadList = new ArrayList<>();
		int n = itemList.size();
		if (n > 0 && maxWeight > 0) {
			List<List<Integer>> c = new ArrayList<List<Integer>>();
			List<Integer> curr = new ArrayList<Integer>();

			c.add(curr);
			for (int j = 0; j <= maxWeight; j++)
				curr.add(0);
			for (int i = 1; i <= n; i++) {
				List<Integer> prev = curr;
				c.add(curr = new ArrayList<Integer>());
				for (int j = 0; j <= maxWeight; j++) {
					if (j > 0) {
						int wH = itemList.get(i - 1).getWeight();
						curr.add((wH > j) ? prev.get(j)
								: Math.max(prev.get(j), itemList.get(i - 1).getPrice() + prev.get(j - wH)));
					} else {
						curr.add(0);
					}
				}
			}
			bestLoadPrice = curr.get(maxWeight);

			for (int i = n, j = maxWeight; i > 0 && j >= 0; i--) {
				int tempI = c.get(i).get(j);
				int tempI_1 = c.get(i - 1).get(j);
				if ((i == 0 && tempI > 0) || (i > 0 && tempI != tempI_1)) {
					Item iH = itemList.get(i - 1);
					int wH = iH.getWeight();
					bestItemsLoadList.add(iH);
					j -= wH;
					solutionWeight += wH;
				}
			}
			calculated = true;
		}
		return bestItemsLoadList;
	}

	public static Integer getBestLoadPrice() {
		return bestLoadPrice;
	}

	public static Integer getSolutionWeight() {
		return solutionWeight;
	}

	public static boolean isCalculated() {
		return calculated;
	}

	public static Integer getBestLoadPrice(List<Item> itemList, Integer maxWeight) {
		if (!calculated)
			getBestItemLoad(itemList, maxWeight);
		return bestLoadPrice;
	}

}
