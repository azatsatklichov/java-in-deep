package net.sahet.practical.java;

/**
 * Legal Expressions for switch and case The general form of the switch
 * statement is:
 * 
 * <pre>
 * 
 * switch (expression) {
 *   case constant1: code block
 *   case constant2: code block
 *   default: code block
 * }
 * 
 * 
 * A switch's expression must evaluate to a char, byte, short, int, or, as of Java 
 * 6, an enum, Java 7 String.  That means if you're not using an enum, only variables and values 
 * that can be automatically promoted (in other words, implicitly cast) to an int are 
 * acceptable. You won't be able to compile if you use anything else, including the 
 * remaining numeric types of long, float, and double.
 * 
 * 
 * A case constant must evaluate to the same type as the switch expression can 
 * use, with one additional—and big—constraint: the case constant must be a 
 * compile time constant! Since the case argument has to be resolved at compile 
 * time, that means you can use only a constant or final variable that is assigned a 
 * literal value. It is not enough to be final, it must be a compile time constant. For 
 * example:
 * 
 * 
 * final int a = 1;
 * final int b;
 * b = 2;
 * int x = 0;
 * switch (x) {
 *   case a:     // ok
 *   case b:     // compiler error
 * </pre>
 * 
 */
public class LegalExpressionForSwitchAndCase {

	public static void main(String[] args) {

		final int a = 1;
		final int b; /// no compiler time constant
		b = 2;
		int x = 0;
		switch (x) {
		case a: // ok
//		case b: // compiler error
		}

		/*
		 * Also, the switch can only check for equality. This means that the other
		 * relational operators such as greater than are rendered unusable in a case.
		 * The following is an example of a valid expression using a method invocation
		 * in a switch statement. Note that for this code to be legal, the method being
		 * invoked on the object reference must return a value compatible with an int.
		 */
		String s = "xyz";
		switch (s.length()) {
		case 1:
			System.out.println("length is one");
			break;
		case 2:
			System.out.println("length is two");
			break;
		case 3:
			System.out.println("length is three");
			break;
		default:
			System.out.println("no match");
		}

		/*
		 * One other rule you might not expect involves the question, "What happens if I
		 * switch on a variable smaller than an int?" Look at the following switch:
		 */
		byte g = 2;
		switch (g) {
		case 23:
			// case 128: //possible loss of precision
		}

		/*
		 * It's also illegal to have more than one case label using the same value. For
		 * example, the following block of code won't compile because it uses two cases
		 * with the same value of 80:
		 */
		int temp = 90;
		switch (temp) {
		case 80:
			System.out.println("80");
			// case 80 : System.out.println("80"); // won't compile! duplicate CASE
		case 90:
			System.out.println("90");
		default:
			System.out.println("default");
		}

		/*
		 * It is legal to leverage the power of boxing in a switch expression. For
		 * instance, the following is legal:
		 */
		switch (new Integer(4)) { // for switch - no need to be compiler-time-constant, but CASE yes
		case 4:
			System.out.println("boxing is OK");
		}

		/*
		 * Look for any violation of the rules for switch and case arguments. For
		 * example, you might �? nd illegal examples like the following snippets:
		 */
		// without COLON
		/*
		 * switch(x) { case 0 { y = 7; } }
		 */
		// without case
		/*
		 * switch(x) { 0: { } 1: { } }
		 */

	}
}

class Switch_Break {
	public static void main(String[] args) {
		int x = 1;
		switch (x) {
		case 1: {
			System.out.println("x is one");
			break;
		}
		case 2: {
			System.out.println("x is two");
			break;
		}
		case 3: {
			System.out.println("x is two");
			break;
		}
		}
		System.out.println("out of the switch");

		// /DEFAULT test
		switch (x) {
		case 2:
			System.out.println("2");
		default:
			System.out.println("default");
		case 3:
			System.out.println("3");
		case 4:
			System.out.println("4");
		}

		// /////// one out for multiple switch param ///////
		int even = someNumberBetweenOneAndTen();

		switch (even) { // try 3
		case 2:
		case 4:
		case 6:
		case 8:
		case 10: {
			System.out.println(even + " is an even number");
			break;
		}
		default:
			System.out.println("x is an odd number");
		}
	}

	private static int someNumberBetweenOneAndTen() {
		// /suppose returns even number betweenb 0-10
		return (int) (Math.random() * 10 + 1);
	}

}

enum Color {
	red, green, blue
}

/**
 * Break and Fall-Through in switch Blocks
 * 
 * 
 * <pre>
 * 
 * We're finally ready to discuss the break statement, and more details about flow 
 * control within a switch statement. The most important thing to remember about 
 * the flow of execution through a switch statement is this:
 * case constants are evaluated from the top down, and the first case constant 
 * that matches the switch's expression is the execution entry point.
 * 
 * 
 * In other words, once a case constant is matched, the JVM will execute the 
 * associated code block, and ALL subsequent code blocks (barring a break statement) 
 * too! The following example uses an enum in a case statement.
 * </pre>
 * 
 */
class SwitchEnum {
	public static void main(String[] args) {
		Color c = Color.green;
		switch (c) {
		case red:
			System.out.print("red ");
		case green:
			System.out.print("green ");
		case blue:
			System.out.print("blue ");
		default:
			System.out.println("done");
		}
		/**
		 * Again, when the program encounters the keyword break during the execution of
		 * a switch statement, execution will immediately move out of the switch block
		 * to the next statement after the switch. If break is omitted, the program just
		 * keeps executing the remaining case blocks until either a break is found or
		 * the switch statement ends. Examine the following code:
		 */

		System.out.println("\n  without break");
		int x = 1;
		switch (x) {
		case 1:
			System.out.println("x is one");
		case 2:
			System.out.println("x is two");
		case 3:
			System.out.println("x is three");
		}
		/**
		 * This combination occurs because the code didn't hit a break statement;
		 * execution just kept dropping down through each case until the end. This
		 * dropping down is actually called "fall-through," because of the way execution
		 * falls from one case to the next. Remember, the matching case is simply your
		 * entry point into the switch block! In other words, you must not think of it
		 * as, "Find the matching case, execute just that code, and get out." That's not
		 * how it works. If you do want that "just the matching code" behavior, you'll
		 * insert a break into each case as follows:
		 */
		System.out.println("\n  break");
		x = 1;
		switch (x) {
		case 1: {
			System.out.println("x is one");
			break;
		}
		case 2: {
			System.out.println("x is two");
			break;
		}
		case 3: {
			System.out.println("x is two");
			break;
		}
		}
		System.out.println("out of the switch");

		// An interesting example of this fall-through logic is shown in the
		// following code:
		x = someNumberBetweenOneAndTen();
		switch (x) {
		case 2:
		case 4:
		case 6:
		case 8:
		case 10: {
			System.out.println("x is an even number");
			break;
		}
		}
		/**
		 * Note: Because fall-through is less than intuitive, Sun recommends that you
		 * add a comment like: // fall through when you use fall-through logic.
		 */

		System.out.println("\n  The Default Case");
		switch (x) {
		case 2:
		case 4:
		case 6:
		case 8:
		case 10: {
			System.out.println("x is an even number");
			break;
		}
		default:
			System.out.println("x is an odd number");
		}

		/*
		 * The default case doesn’t have to come at the end of the switch. Look for it
		 * in strange places such as the following:
		 */
		System.out.println("\n  The default case doesn’t have to come at the end");
		x = 2;
		switch (x) {
		case 2:
			System.out.println("2");
		default:
			System.out.println("default");
		case 3:
			System.out.println("3");
		case 4:
			System.out.println("4");
		}
	}

	private static int someNumberBetweenOneAndTen() {
		// /suppose returns even number betweenb 0-10
		return (int) (Math.random() * 10 + 1);
	}
}

class SinceJava13StickExpression {
	// this allows assign returned value
	// using lambdas
	// and yielding etc...
}