package com.qaprosoft.stockproject.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.stockproject.entity.Item;
import com.qaprosoft.stockproject.entity.transport.Train;

public class TestAlg {

    private static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {

	List<Item> items = new ArrayList<>();
	Train train = new Train();
	train.setMaxCarryingCapacity(8);
	items.add(new Item("Table", 1, 600));
	items.add(new Item("Umbrella", 2, 5000));
	items.add(new Item("Cat", 4, 1500));
	items.add(new Item("Ball", 2, 40000));
	items.add(new Item("Chair", 1, 500));

	logger.info("1");

	AlgorithmforBestLoad algorithmforBestLoad = new AlgorithmforBestLoad();

	algorithmforBestLoad.makeAllSets(items, train);
	logger.info(algorithmforBestLoad.getBestLoadPrice());

	List<Item> solve = algorithmforBestLoad.getBestItemLoad();
	System.out.println(solve);

    }

}
