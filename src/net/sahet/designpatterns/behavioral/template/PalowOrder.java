package net.sahet.designpatterns.behavioral.template;

public class PalowOrder extends FoodOrder {

	@Override
	public void askOrder() {
		System.out.println("What would you like to order ? ... Thanks for ordering palow");
	} 

	@Override
	public void makeService() {
		System.out.println("Please, take your Palow, and enjoy it.");
	}
}
