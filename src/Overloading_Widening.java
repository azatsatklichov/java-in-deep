package net.sahet.iviews;

/**
 * Overloading Made Hard—Method Matching
 * 
 * <pre>
 * 
 * Although we covered some rules for overloading methods in Chapter 2, in this 
 * chapter we've added some new tools to our Java toolkit. In this section we're going 
 * to take a look at three factors that can make overloading a little tricky:
 * 
 * ■ Widening
 * ■ Autoboxing
 * ■ Var-args
 * </pre>
 * 
 */
public class Overloading_Widening {

	/**
	 * 
	 * 
	 * 
	 * In every case, when an exact match isn't found, the JVM uses the method
	 * with the smallest argument that is wider than the the parameter
	 * 
	 * 
	 * - Widening - Autoboxing - Var-args
	 */
}

/*
 * When a class has overloaded methods, one of the compiler's jobs is to
 * determine which method to use whenever it finds an invocation for the
 * overloaded method. Let's look at an example that doesn't use any new Java 5
 * features:
 */
class EasyOver {
	static void go(int x) {
		System.out.println("int ");
	}

	static void go(long x) {
		System.out.println("long ");
	}

	static void go(double x) {
		System.out.println("double ");
	}

	public static void main(String[] args) {
		byte b = 5;
		short s = 5;
		long l = 5;
		float f = 5.0f;
		go(b);
		go(s);
		go(l);
		go(f);
	}
}
