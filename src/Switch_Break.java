package net.sahet.iviews;

public class Switch_Break {
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
		 * Again, when the program encounters the keyword break during the
		 * execution of a switch statement, execution will immediately move out
		 * of the switch block to the next statement after the switch. If break
		 * is omitted, the program just keeps executing the remaining case
		 * blocks until either a break is found or the switch statement ends.
		 * Examine the following code:
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
		 * This combination occurs because the code didn't hit a break
		 * statement; execution just kept dropping down through each case until
		 * the end. This dropping down is actually called "fall-through,"
		 * because of the way execution falls from one case to the next.
		 * Remember, the matching case is simply your entry point into the
		 * switch block! In other words, you must not think of it as, "Find the
		 * matching case, execute just that code, and get
		 * out." That's not how it works. If you do want that "just the matching
		 * code" behavior, you'll insert a break into each case as follows:
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
		 * Note: Because fall-through is less than intuitive, Sun recommends
		 * that you add a comment like: // fall through when you use
		 * fall-through logic.
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
		 * The default case doesn’t have to come at the end of the switch. Look
		 * for it in strange places such as the following:
		 */
		System.out
				.println("\n  The default case doesn’t have to come at the end");
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
	//this allows assign returned value
	//using lambdas
	//and yielding etc...
}