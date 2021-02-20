package net.sahet.designpatterns.creational.factorymethod;

abstract class Pizza {
	public abstract int getPrice();
}

class Margherita extends Pizza {
	public int getPrice() {
		return 139;
	}
}

class QuattroFormaggi extends Pizza {
	public int getPrice() {
		return 169;
	}
}

class HawaiianPizza extends Pizza {
	public int getPrice() {
		return 189;
	}
}

class PizzaFactory {

	enum PizzaType {
		MARGHERITA, QUATTROFORMAGGI, HAWAIIANPIZZA
	}

	public static Pizza createPizza(PizzaType pizzaType) {
		switch (pizzaType) {
		case MARGHERITA:
			return new Margherita();
		case QUATTROFORMAGGI:
			return new QuattroFormaggi();
		case HAWAIIANPIZZA:
			return new HawaiianPizza();
		}
		throw new IllegalArgumentException("We do not have such " + pizzaType + " pizza");
	}
}
