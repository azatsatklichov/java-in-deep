package net.sahet.iviews;

class Att {
}

class Btt extends Att {
}

class ComingThru {
	static String s = "-";

	/**
	 * <p>
	 * Description: What is the result?
	 * </p>
	 * 
	 * <pre>
	 * 
	 *    A.  -124
	 *    B.  -134
	 *    C.  -424
	 *    D.  -434   (correct)  In general, overloaded var-args methods are chosen last. Remember that arrays 
	 * are objects. Finally, an int can be boxed to an Integer and then "widened" to an Object.
	 * 
	 *    E.  -444
	 *    F. Compilation fails
	 * 
	 * </pre>
	 */
	public static void main(String[] args) {
		Att[] aa = new Att[2];
		Btt[] ba = new Btt[2];
		sifter(aa);
		sifter(ba);
		sifter(7);
		System.out.println(s);
	}

	static void sifter(Att[]... a2) {
		System.out.println("sifter(Att[]... a2)");
		s += "1";
	}

	static void sifter(Btt[]... b1) {
		System.out.println("sifter(Btt[]... b1)");
		s += "2";
	}

	static void sifter(Btt[] b1) {
		System.out.println("sifter(Btt[] b1)");
		s += "3";
	}

	static void sifter(Object o) {
		System.out.println("sifter(Object o)");
		s += "4";
	}
}