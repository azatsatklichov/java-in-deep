package net.sahet.java.core.lang.building.blocks;

class DecisionMakerLogic {
	public static void main(String[] args) {

		int x = 1;

		if (x == 3) {
		} else if (x < 4) {
			System.out.println("<4");
		} else if (x < 2) {
			System.out.println("<2");
		} else {
			System.out.println("else");
		}

		int y = 2, z = 3;

		System.out.println("using short circuit ");

		// prints nothing
		if (((z > 3) && (y < 2))) {
			System.out.println("true");
		}

		if ((z > 3) && (y < 2) || doStuff()) {
			System.out.println("true");
		}

		System.out.println("using full circuit ");
		if (((z > 3) & (y < 2)) | doStuff()) {
			System.out.println("true");
		}

		// prints nothing
		if ((z > 3) && (y < 2) | doStuff()) {
			System.out.println("true");
		}
	}

	private static boolean doStuff() {
		return true;
	}
}
