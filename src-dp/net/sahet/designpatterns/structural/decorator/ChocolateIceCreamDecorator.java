package net.sahet.designpatterns.structural.decorator;

public class ChocolateIceCreamDecorator extends IceCreamDecorator {

	public ChocolateIceCreamDecorator(IceCream iceCream) {
		super(iceCream);
	}

	public String iceCream() {
		return iceCream.iceCream() + addChocolate();
	}

	private String addChocolate() {
		return " + chocolate";
	}
}
