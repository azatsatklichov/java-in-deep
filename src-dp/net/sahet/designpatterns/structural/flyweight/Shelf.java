package net.sahet.designpatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Caches flyweight objects
 *
 */
public class Shelf {

	private Map<String, Heavy> items = new HashMap<>();

	public Heavy lookup(String itemName) {
		if (!items.containsKey(itemName)) {
			items.put(itemName, new Heavy(itemName));
		}

		return items.get(itemName);
	}

	public int totalItemsMade() {
		return items.size();
	}
}
