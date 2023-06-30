package net.sahet.iviews;

public class DecisionMaker_IfElse {
	public static void main(String[] args) {
		/*
		 * if (x > 3) { y = 2; } z += 8; a = y + x;
		 */

		int x = 1;
		if (x == 3) {
		} else if (x < 4) {
			System.out.println("<4");
		} else if (x < 2) {
			System.out.println("<2");
		} else {
			System.out.println("else");
		}
	}

}

class IfElse {
	public static void main(String[] args) {
		int x = 3, y = 2;

		if (((x > 3) && (y < 2)) | doStuff()) {
			System.out.println("true");
		}

		// prints nothing
		if ((x > 3) && (y < 2) | doStuff()) {
			System.out.println("true");
		}
	}

	private static boolean doStuff() {
		return true;
	}

}

