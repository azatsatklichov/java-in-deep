package net.sahet.designpatterns.behavioral.template;

public class SomsaOrder extends FoodOrder {

	@Override
	public void askOrder() {
		System.out.println("What would you like to order ? ... Thanks for ordering somsa");
	}

	@Override
	public void makeService() {
		System.out.println("Please, take your Somsa, and enjoy it.");
	}
}
