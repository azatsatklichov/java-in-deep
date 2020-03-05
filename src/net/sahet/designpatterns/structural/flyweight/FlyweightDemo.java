package net.sahet.designpatterns.structural.flyweight;

import java.io.IOException;

public class FlyweightDemo {
	public static void main(String[] args) throws IOException {

		System.out.println("\n	Flyweight Java build-in classes ");
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
}
