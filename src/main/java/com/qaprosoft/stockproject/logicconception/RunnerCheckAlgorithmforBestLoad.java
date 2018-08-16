package com.qaprosoft.stockproject.logicconception;

import java.util.ArrayList;
import java.util.List;


import com.qaprosoft.stockproject.entity.Item;

public class RunnerCheckAlgorithmforBestLoad {
   
    public static void main(String[] args) {
	
	List<Item> items = new ArrayList<>();

	items.add(new Item("Table", 1, 600));
	items.add(new Item("Umbrella", 2, 5000));
	items.add(new Item("Cat", 4, 1500));
	items.add(new Item("Ball", 2, 40000));
	items.add(new Item("Chair", 1, 500));
	
	System.out.println("1");
    }

}
