package net.sahet.designpatterns.structural.flyweight;

import java.io.IOException;

public class FlyweightDemo {
	public static void main(String[] args) throws IOException {
		System.out.println("\n	Flyweight design pattern example ");
		Registry registry = new Registry();

		getRegistry(registry);
		registry.process();
		System.out.println("\nWOW Power of Flyweight: " + registry.report());

		System.out.println("\n\n	Flyweight Java build-in classes ");
		/**
		 * java.lang.String
		 * 
		 * and all Wrapper classes with valueOf(int) methods
		 * 
		 * Integer, Boolean, Byte, Character, Short, Long
		 * 
		 */
		String s1 = "ha endi";
		String s2 = "ha endi";

		System.out.println(s1 == s2);

		Integer i1 = Integer.valueOf(5);
		Integer i2 = Integer.valueOf(5);
		Integer i3 = Integer.valueOf(15);
		System.out.println(i1 == i2);
		System.out.println(i1 == i3);
	}

	private static void getRegistry(Registry registry) {
		registry.takeOrder("Toshiba", 1323);
		registry.takeOrder("Sony", 2323);
		registry.takeOrder("Samsung", 2124);
		registry.takeOrder("Samsung", 1144);
		registry.takeOrder("Sony", 3323);
		registry.takeOrder("Sony", 5323);
		registry.takeOrder("Toshiba", 2323);
		registry.takeOrder("Sadko", 112);
		registry.takeOrder("xITee", 675);
		registry.takeOrder("Sadko", 142);
		registry.takeOrder("Sony", 7323);
		registry.takeOrder("Toshiba", 1313);
		registry.takeOrder("Toshiba", 1343);
	}
}
