package net.sahet.iviews;

public class Test_Exception {

}

class Plane {
	static String s = "-";

	public static void main(String[] args) {
		new Plane().s1();
		System.out.println(s);
	}

	void s1() {
		try {
			System.out.println("s1-run this");
			s2();
		} catch (Exception e) {
			s += "c";
		}
	}

	void s2() throws Exception {
		System.out.println("  s2-run this");
		s3();
		System.out.println(" not run this");
		s += "2";
		s3();
		s += "2b";
	}

	void s3() throws Exception {
		System.out.println("   s3-run this");
		throw new Exception();
	}
}

// // another test
/**
 * And given the following three code fragments:
 * 
 * <pre>
 * 
 * I.   new Gotcha().go();
 * II.  try { new Gotcha().go(); } 
 *     catch (Error e) { System.out.println("ouch"); }
 * III. try { new Gotcha().go(); }
 *     catch (Exception e) { System.out.println("ouch"); }
 *     
 * When fragments I - III are added, independently, at line 5, which are true? (Choose all that apply.)
 * 
 *   A. Some will not compile
 *   B. They will all compile
 *   C. All will complete normally
 *   D. None will complete normally
 *   E. Only one will complete normally
 *   F. Two of them will complete normally
 *   
 *   
 *   Answer:
 *   
 *     ✓   B and E are correct. First off, go() is a badly designed recursive method, guaranteed to 
 * cause a StackOverflowError. Since Exception is not a superclass of Error, catching an 
 * Exception will not help handle an Error, so fragment III will not complete normally. 
 * Only fragment II will catch the Error.
 * 
 *       A, C, D, and F are incorrect based on the above. (Objective 2.5)
 * </pre>
 * 
 */
class Gotcha {
	public static void main(String[] args) {

		// insert code here

	}

	void go() {
		go();
	}
}
