package net.sahet.designpatterns.behavioral.template;

public abstract class FoodOrder {

	public abstract void askOrder();

	private boolean isTakeAway;

	public void askPayment() {
		System.out.println("How would you like to do payment, cash or card? ");
	}

	public void giveReceipt() {
		System.out.println("Please, take your receipt, and we are preparing the food in a while");
	}

	public abstract void makeService();

	public final void processOrder() {
		askOrder();
		askPayment();
		if (isTakeAway) {
			pack();
		}
		giveReceipt();
		makeService();
	}

	public final void pack() {
		System.out.println("Pack the food");
	}
}
