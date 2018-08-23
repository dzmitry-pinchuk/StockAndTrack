package com.qaprosoft.stockproject.draft;

import java.util.ArrayList;
import java.util.List;

import com.qaprosoft.stockproject.entity.Item;

public class AlgorithmforBestLoad {

    private List<Item> bestItemsLoadList;
    private int solutionWeight;
    private int bestLoadPrice;
    private boolean calculated;

    public  List<Item> getBestItemLoad(List<Item> itemList, Integer maxWeight) {
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

    // public static Integer getBestLoadPrice(List<Item> itemList, Integer maxWeight) {
    // if (!calculated)
    // getBestItemLoad(itemList, maxWeight);
    // return bestLoadPrice;
    // }

    public Integer getBestLoadPrice() {
	return bestLoadPrice;
    }

    public Integer getSolutionWeight() {
	return solutionWeight;
    }

    public boolean isCalculated() {
	return calculated;
    }

    public Integer getBestLoadPrice(List<Item> itemList, Integer maxWeight) {
	if (!calculated)
	    getBestItemLoad(itemList, maxWeight);
	return bestLoadPrice;
    }

}

// public class AlgorithmForRefactoring {
//
// // A utility function that returns
// // maximum of two integers
// static int max(int a, int b) {
// return (a > b) ? a : b;
// }
//
// // Prints the items which are put
// // in a knapsack of capacity W
// static void printknapSack(int W, int wt[], int val[], int n) {
// int i, w;
// int K[][] = new int[n + 1][W + 1];
//
// // Build table K[][] in bottom up manner
// for (i = 0; i <= n; i++) {
// for (w = 0; w <= W; w++) {
// if (i == 0 || w == 0)
// K[i][w] = 0;
// else if (wt[i - 1] <= w)
// K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]], K[i - 1][w]);
// else
// K[i][w] = K[i - 1][w];
// }
// }
//
// // stores the result of Knapsack
// int res = K[n][W];
// System.out.println(res);
//
// w = W;
// for (i = n; i > 0 && res > 0; i--) {
//
// // either the result comes from the top
// // (K[i-1][w]) or from (val[i-1] + K[i-1]
// // [w-wt[i-1]]) as in Knapsack table. If
// // it comes from the latter one/ it means
// // the item is included.
// if (res == K[i - 1][w])
// continue;
// else {
//
// // This item is included.
// // System.out.print(wt[i - 1] + " ");
// System.out.print(wt[i - 1] + " ");
//
// // Since this weight is included its
// // value is deducted
// res = res - val[i - 1];
// w = w - wt[i - 1];
// // System.out.print(val[i - 1] + " ");
// }
// }
//
// }
//
// // Driver code
// public static void main(String arg[]) {
// int val[] = { 60, 100, 120, 110, 120, 130, 140, 150, 160, 100, 104, 108, 120,
// 140, 160, 174, 120, 120, 130, 120,
// 160, 120, 120, 45, 121, 124, 127, 234, 789, 678 };
// int wt[] = { 10, 20, 30, 40, 67, 45, 44, 78, 78, 89, 98, 56, 54, 34, 5, 7,
// 78, 89, 67, 67, 78, 79, 75, 58, 49,
// 29, 89, 55, 12, 40 };
// int W = 200;
// int n = val.length;
//
// printknapSack(W, wt, val, n);
//
// }
// }

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