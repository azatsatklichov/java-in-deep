package net.sahet.designpatterns.structural.composite;

import java.util.HashMap;
import java.util.Map;

public class CompositeDemo {
	public static void main(String[] args) {

		System.out.println("\n	Composite Java build-in classes ");
		/**
		 * java.awt.Component
		 * 
		 * JSF widgeds
		 * 
		 * 
		 * RESTfull services GETs
		 */
		Map<String, String> map1 = new HashMap<>();
		map1.put("a", "auto");
		map1.put("A", "AUTO");
		System.out.println(map1);

		Map<String, String> map2 = new HashMap<>();
		map2.put("b", "bus");
		map2.put("B", "BUS");
		System.out.println(map2);

		Map<String, String> map3 = new HashMap<>();
		map3.putAll(map1);
		map3.putAll(map2);
		System.out.println(map3);

	}
}
