package net.sahet.iviews;

public class Test_YSoft {
	public static void main(String[] args) {
		String x = "Java"; // Assign a value to x
		System.out.println("x string = " + x);
		String y = x; // Now y and x refer to the same
		// String object
		System.out.println("y string = " + y);
		x = x + " Bean"; // Now modify the object using the x reference
		System.out.println("x string = " + x);
		System.out.println("y string = " + y);
	}
}