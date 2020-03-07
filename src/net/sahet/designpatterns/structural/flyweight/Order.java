package net.sahet.designpatterns.structural.flyweight;

public class Order {
	private final int orderNumber;
	private final Heavy item;

	public Order(int orderNumber, Heavy item) {
		this.orderNumber = orderNumber;
		this.item = item;
	}

	public void processOrder() {
		System.out.println("Ordering " + item + " for order number " + orderNumber);
	}
}
