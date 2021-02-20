package net.sahet.designpatterns.structural.flyweight;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Registry {
	private final Shelf shelf = new Shelf();
	private final List<Order> orders = new CopyOnWriteArrayList<>();

	public void takeOrder(String itemName, int orderNumber) {
		Heavy item = shelf.lookup(itemName);
		Order order = new Order(orderNumber, item);
		orders.add(order);
	}

	public void process() {
		for (Order order : orders) {
			order.processOrder();
			orders.remove(order);
		}
	}

	public String report() {
		return "Total Item objects made: " + shelf.totalItemsMade();
	}
}
