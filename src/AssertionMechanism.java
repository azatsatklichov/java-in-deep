package net.sahet.iviews;

/**
 * Added to the Java language beginning with version 1.4, assertions let you
 * test your assumptions during development, without the expense (in both your
 * time and program overhead) of writing exception handlers for exceptions that
 * you assume will never happen once the program is out of development and fully
 * deployed. Starting with exam 310-035 (version 1.4 of the Sun Certified Java
 * Programmer exam) and continuing with the current exam 310-055 (version 5),
 * you're expected to know the basics of how assertions work, including how to
 * enable them, how to use them, and how not to use them.
 * 
 */
public class AssertionMechanism {

	/*
	 * Suppose you assume that a number passed into a method (say, methodA())
	 * will never be negative. While testing and debugging, you want to validate
	 * your assumption, but you don't want to have to strip out print
	 * statements, runtime exception handlers, or if/else tests when you're done
	 * with development. But leaving any of those in is, at the least, a
	 * performance hit. Assertions to the rescue! Check out the following code:
	 */
	private void methodA(int num) {
		if (num >= 0) {
			int x = 0; // or other x
			useNum(num + x);
		} else { // num must be < 0
			// This code should never be reached!
			System.out.println("Yikes! num is a negative number! " + num);
		}
	}

	/*
	 * Because you're so certain of your assumption, you don't want to take the
	 * time (or program performance hit) to write exception-handling code. And
	 * at runtime, you don't want the if/else either because if you do reach the
	 * else condition, it means your earlier logic (whatever was running prior
	 * to this method being called) is flawed. Assertions let you test your
	 * assumptions during development, but the assertion code basically
	 * evaporates when the program is deployed, leaving behind no overhead or
	 * debugging code to track down and remove. Let's rewrite methodA() to
	 * validate that the argument was not negative:
	 */
	private void methodA2(int num) {
		assert (num >= 0); // throws an AssertionError
		int x = 0; // or other x
		// if this test isn't true
		System.out.println(" --ea--");
		useNum(num + x);
	}

	private void useNum(int i) {
		// ODO Auto-generated method stub

	}

	//Run with "-ea"  in VM arguments
	public static void main(String[] args) {
		// enabling assertions -- ea in JVM parameter, or -da
		new AssertionMechanism().methodA2(6);
		new AssertionMechanism().methodA2(-6);
	}

}

class AssertionsOverview {

	/**
	 * Assertions Overview Suppose you assume that a number passed into a method
	 * (say, methodA()) will never be negative.
	 * 
	 * While testing and debugging, you want to validate your assumption, but
	 * you don't want to have to strip out print statements, runtime exception
	 * handlers, or if/else tests when you're done with development.
	 * 
	 * But leaving any of those in is, at the least, a performance hit.
	 * Assertions to the rescue! Check out the following code:
	 */
	private void methodA(int num) {
		if (num >= 0) {
			int x = 9;
			useNum(num + x);
		} else { // num must be < 0
					// This code should never be reached!
			System.out.println("Yikes! num is a negative number! " + num);
		}
	}

	private void useNum(int i) {
		// TODO Auto-generated method stub
	}

	/**
	 * Assertions let you test your assumptions during development, but the
	 * assertion code basically evaporates when the program is deployed, leaving
	 * behind no overhead or debugging code to track down and remove.
	 * 
	 * Let's rewrite methodAWithAssertion() to validate that the argument was
	 * not negative:
	 */
	private void methodAWithAssertion(int num) {
		assert (num >= 0); // throws an AssertionError
							// if this test isn't true
		int x = 9;
		useNum(num + x);
	}

	/**
	 * Not only do assertions let your code stay cleaner and tighter, but
	 * 
	 * because assertions are inactive unless specifically "turned on"
	 * (enabled), the code will run as though it were written like this:
	 */
	private void methodAWithAssertion2(int num) {
		int x = 9;
		useNum(num + x); // we've tested this;
							// we now know we're good here
	}

}

/**
 * Desc:
 * 
 * <pre>
 * Assertions work quite simply. You always assert that something is true. If it is, no 
 * problem. Code keeps running. But if your assertion turns out to be wrong (false), 
 * then a stop-the-world AssertionError is thrown (that you should never, ever 
 * 
 * handle!) right then and there, so you can fix whatever logic flaw led to the problem.
 * Assertions come in two flavors: really simple and simple, as follows:
 * 
 * 
 * Really simple:
 * private void doStuff() {
 *   assert (y > x);
 *   // more code assuming y is greater than x
 * }
 * 
 * 
 * Simple:
 * private void doStuff() {
 *   assert (y > x): "y is " + y + " x is " + x;
 *   // more code assuming y is greater than x
 * }
 * </pre>
 * 
 * The difference between the two is that the simple version adds a second
 * expression, separated from the first (boolean expression)
 * 
 * by a colon,
 * 
 * this expression's string value is added to the stack trace.
 * 
 * Both versions throw an immediate AssertionError, but the simple version gives
 * you a little more debugging help while the really simple version simply tells
 * you only that your assumption was false.
 * 
 */
class AssertionTypes {

	// Really simple:
	private void doStuff() {
		int y = 3, x = 2; // e.g.
		assert (y > x);
		// more code assuming y is greater than x
	}

	// Simple:
	private void doStuff2() {
		int y = 3, x = 2; // e.g.
		assert (y > x) : "y is " + y + " x is " + x;
		// more code assuming y is greater than x
	}
}

class LegalIllegalAssertions {
	/**
	 * The second expression, used only with the simple version of an assert
	 * statement, can be anything that results in a value.
	 * 
	 * Remember, the second expression is used to generate a String message that
	 * displays in the stack trace to give you a little more debugging
	 * information.
	 * 
	 * It works much like System.out.println() in that you can pass it a
	 * primitive or an object, and it will convert it into a String
	 * representation.
	 * 
	 * It must resolve to a value!
	 * 
	 * 
	 */
	void noReturn() {
	}

	int aReturn() {
		return 1;
	}

	/**
	 * The following code lists legal and illegal expressions for both parts of
	 * an assert statement.
	 * 
	 * Remember, expression2 is used only with the simple assert statement,
	 * where the second expression exists solely to give you a little more
	 * debugging detail:
	 */
	void go() {
	  int x = 1;
	  boolean b = true;
	  // the following six are legal assert statements
	  assert(x == 1);
	  assert(b);
	  assert true;
	  //second expression must have  RETURN value
	  assert(x == 1) : x;
	  assert(x == 1) : aReturn();
	  assert(x == 1) : new ValidAssert();
	  
	  
	  // the following six are ILLEGAL assert statements
//	  assert(x = 1);  // none of these are booleans
//	  assert(x);
//	  assert 0;
//	  assert(x == 1) : ;           // none of these return a value
//	  assert(x == 1) : nOReturn();
//	  assert(x == 1) : ValidAssert va;
	}
	
	void nOReturn() {
		//no return 
	}
}

// TBD
class ValidAssert {

}
