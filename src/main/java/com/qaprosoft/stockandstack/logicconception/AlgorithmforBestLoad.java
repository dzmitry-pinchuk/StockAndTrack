package com.qaprosoft.stockandstack.logicconception;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.entity.Item;


public class AlgorithmforBestLoad {
    
    
    private static final Logger lOGGER = LogManager.getLogger(AlgorithmforBestLoad.class);

    List <Item> items;
    

    int knapsack(int weights[], int costs[], int needed) {
	int n = weights.length;
	int dp[][] = new int[needed + 1][n + 1];
	for (int j = 1; j <= n; j++) {
	    for (int w = 1; w <= needed; w++) {
		if (weights[j - 1] <= w) {
		    dp[w][j] = Math.max(dp[w][j - 1], dp[w - weights[j - 1]][j - 1] + costs[j - 1]);
		} else {
		    dp[w][j] = dp[w][j - 1];
		}
	    }
	}
	return dp[needed][n];
    }
}
