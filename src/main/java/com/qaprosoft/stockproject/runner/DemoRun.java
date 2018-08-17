package com.qaprosoft.stockproject.runner;

import com.qaprosoft.stockproject.parsing.ClassForJaxB;
import com.qaprosoft.stockproject.parsing.JaxonParser;

public class DemoRun {

	public static void main(String[] args) {
		System.out.println("Hello world");
		
		JaxonParser jp = new JaxonParser();
		jp.writeToJson();
		System.out.println("all done");

		
//		ClassForJaxB temp = new ClassForJaxB();
//		System.out.println(temp);
	}

}
