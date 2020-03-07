package net.sahet.designpatterns.structural.decorator;

public class MelonIceCreamDecorator extends IceCreamDecorator {

	public MelonIceCreamDecorator(IceCream iceCream) {
		super(iceCream);
	}

	public String iceCream() {
		return iceCream.iceCream() + addMelon();
	}

	private String addMelon() {
		return " + melon";
	}
}
