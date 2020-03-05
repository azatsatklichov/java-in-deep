package net.sahet.designpatterns.structural.adapter;

import java.util.Arrays;
import java.util.List;

public class AdapterDemo {
	public static void main(String[] args) {

		System.out.println("\n	Adapter Java build-in classes ");
		/**
		 * Arrays -> List (Array adapts to List)
		 * 
		 * Streams has full of adapter methods
		 * 
		 */
		Integer[] intArrs = new Integer[] { 34, 3, -45, 67, 87 };
		List<Integer> intList = Arrays.asList(intArrs);
		System.out.println(intArrs);
		System.out.println(intList);
	}
}
