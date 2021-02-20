package net.sahet.designpatterns.behavioral.template;

public class TemplateDemo {

	public static void main(String[] args) {
		System.out.println("Template design pattern example:");

		FoodOrder somsa = new SomsaOrder();
		somsa.processOrder();
		System.out.println();

		FoodOrder palow = new PalowOrder();
		palow.processOrder();
		System.out.println();

		System.out.println("\n	Template Java build-in classes");
		/**
		 * java.util.Collections#sort()
		 * 
		 * java.util.AbstractList#indexOf()
		 */
	}
}
