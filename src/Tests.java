package net.sahet.iviews;

public class Tests {

}

/**
 * What is the result?
 * 
 * <pre>
 * 
 *    A.  9 10 d
 *    B.  8 9 10 d
 *    C.  9 10 10 d
 *    D.  9 10 10 d 13    --- ans
 *    E.  8 9 10 10 d 13
 *    F.  8 9 10 9 10 10 d 13
 *    G. Compilation fails
 * </pre>
 * 
 */
class Ebb {
	static int x = 7;

	public static void main(String[] args) {
		String s = "";
		for (int y = 0; y < 3; y++) {
			x++;
			switch (x) {
			case 8:
				s += "8 ";
			case 9:
				s += "9 ";
			case 10: {
				s += "10 ";
				break;
			}
			default:
				s += "d ";
			case 13:
				s += "13 ";
			}
		}
		System.out.println(s);
	}

	static {
		x++;
	}
}

// / another example
/**
 * And given that line 7 will assign the value 0, 1, or 2 to sw, which are true?
 * (Choose all that apply.)
 * 
 * 
 * <pre>
 * 
 * A. Compilation fails
 * B. A ClassCastException might be thrown
 * C. A StackOverflowError might be thrown
 * D. A NullPointerException might be thrown
 * E. An IllegalStateException might be thrown
 * F. The program might hang without ever completing
 * G. The program will always complete without exception
 * </pre>
 * 
 */
class Infinity {
}

class Beyond extends Infinity {
	static Integer i;

	public static void main(String[] args) {
		int sw = (int) (Math.random() * 3);
		System.out.println(sw);
		switch (sw) {
		case 0: {
			for (int x = 10; x > 5; x++)
				if (x > 10000000)
					x = 10;
			break;
		}
		case 1: {
			int y = 7 * i;
			/*
			 * 1 Exception in thread "main" java.lang.NullPointerException at
			 * cx55
			 * .and.cx65.ch5.flow.assertion.exceptions.Beyond.main(Tests.java
			 * :87)
			 */

			break;
		}
		case 2: {
			Infinity inf = new Beyond();
			Beyond b = (Beyond) inf;
		}
		}
	}
}

// /3-example
/**
 * What is the result?
 * 
 * <pre>
 * A.  1 3 9
 * B.  5 5 7 7 
 * C.  1 3 3 9 9
 * D.  1 1 3 3 9 9
 * E.  1 1 1 3 3 3 9 9 9
 * F. Compilation fails
 * 
 * </pre>
 * 
 */
class Circlesz {
	public static void main(String[] args) {
		int[] ia = { 1, 3, 5, 7, 9 };
		for (int x : ia) {
			for (int j = 0; j < 3; j++) {
				if (x > 4 && x < 8)
					continue;
				System.out.print(" " + x);
				if (j == 1)
					break;
				continue;
			}
			continue;
		}
	}
}

// //4-example
/**
 * What is the result?
 * 
 * <pre>
 * 
 *          A.  12
 *          B.  13
 *          C.  123
 *          D.  1234
 *          E. Compilation fails
 *          F.  123 followed by an exception
 *          G.  1234 followed by an exception
 *          H. An exception is thrown with no other output
 * </pre>
 * 
 */
class OverAndOver {
	static String s = "";

	public static void main(String[] args) {
		try {
			s += "1";
			throw new Exception();
		} catch (Exception e) {
			s += "2";
		} finally {
			s += "3";
			// System.out.println(s); //I added this, if so, then 123 +
			// Exception
			doStuff();
			s += "4";
		}
		System.out.println(s);
	}

	static void doStuff() {
		int x = 0;
		int y = 7 / x;
	}
}

// /one more example
/**
 * What is the result?
 * 
 * <pre>
 * 
 * A.  0 1 2 3
 * B.  1 1 1 3 3
 * C.  0 1 1 1 2 3 3 -- ans
 * D.  1 1 1 3 3 4 4 4 
 * E.  0 1 1 1 2 3 3 4 4 4 
 * F. Compilation fails
 * </pre>
 * 
 */
class Wind {
	public static void main(String[] args) {
		foreach: for (int j = 0; j < 5; j++) {
			for (int k = 0; k < 3; k++) {
				System.out.print(" " + j);
				if (j == 3 && k == 1)
					break foreach;
				if (j == 0 || j == 2)
					break;
			}
		}
	}
}
