package net.sahet.iviews;

public class ForLoopClassic {
	public static void main(String[] args) {
		// The Basic for Loop: Declaration and Initialization
		System.out
				.println("  The Basic for Loop: Declaration and Initialization");
		/*
		 * The first part of the for statement lets you declare and initialize
		 * zero, one, or multiple variables of the same type inside the
		 * parentheses after the for keyword. If you declare more than one
		 * variable of the same type, then you'll need to separate them with
		 * commas as follows:
		 */
		for (int x = 10, y = 3; y > 3; y++) {
		}
		/*
		 * The declaration and initialization happens before anything else in a
		 * for loop. And whereas the other two parts—the boolean test and the
		 * iteration expression—will run with each iteration of the loop, the
		 * declaration and initialization happens just once, at the very
		 * beginning. You also must know that the scope of variables declared in
		 * the for loop ends with the for loop! The following demonstrates this:
		 */
		for (int x = 1; x < 2; x++) {
			System.out.println(x); // Legal
		}
		// System.out.println(x); // Not Legal! x is now out of scope
		// and can't be accessed.

		System.out
				.println("  Basic for Loop: Conditional (boolean) Expression ");
		boolean someLogic = true;// todo
		for (int x = 10, y = 3; y > 3 && someLogic; y++) {
		}

		// logical expression, but it can be very complex. Look out for code
		// that uses logical

		for (int x = 0, y = 20; ((((x < 10) && (y-- > 2)) | x == 3)); x++) {
			System.out.println(x + " Medvidek Pupert ");
		}

		boolean logic = 10 > 15 ? true : (5 * 5 / 4 > 4) ? true : false;
		//again example of infinite case
		for (int i = 0, j = 9; logic; i++, j--, System.out.println(" gullala")) {
			if (j == 3)
				logic = false;
		}
		// my example

		// The preceding code is legal, but the following is not:
		// for (int x = 0; (x > 5), (y < 2); x++) { } // too many
		// expressions

		System.out.println("\n\n Basic for Loop: for Loop Issues");
		/*
		 * for (;;) { System.out.println("Inside an endless loop"); }
		 */

		/*
		 * In the preceding example, all the declaration parts are left out so
		 * the for loop will act like an endless loop.
		 */
		int i = 0;
		for (; i < 10;) {
			i++;
			// do some other work
			System.out.println(i + " do some other work");
		}

		System.out.println(" \nfor loop with multiple variables");
		/*
		 * The next example demonstrates a for loop with multiple variables in
		 * play. A comma separates the variables, and they must be of the same
		 * type. Remember that the variables declared in the for statement are
		 * all local to the for loop, and can't be used outside the scope of the
		 * loop.
		 */

		for (int ii = 0, j = 0; (ii < 10) && (j < 10); ii++, j++) {
			System.out.println("i is " + i + " j is " + j);
		}

		System.out.println("\n variable scope");
		/*
		 * Variable scope plays a large role in the exam. You need to know that
		 * a variable declared in the for loop can’t be used beyond the for
		 * loop. But a variable only initialized in the for statement (but
		 * declared earlier) can be used beyond the loop. For example, the
		 * following is legal,
		 */
		int x = 3;
		for (x = 12; x < 20; x++) {
		}
		System.out.println(x);
		// while this is not
		/*
		 * for (int xx = 3; xx < 20; xx++) { } System.out.println(xx);
		 */

		System.out
				.println("\n all three sections of the for loop are independent");
		/*
		 * The last thing to note is that all three sections of the for loop are
		 * independent of each other. The three expressions in the for statement
		 * don't need to operate on the same variables, although they typically
		 * do. But even the iterator expression, which many mistakenly call the
		 * "increment expression," doesn't need to increment or set anything;
		 * you can put in virtually any arbitrary code statements that you want
		 * to happen with each iteration of the loop. Look at the following:
		 */
		int b = 3;
		for (int a = 1; b != 1; System.out.println("iterate")) {
			b = b - a;
		}
		System.out.println(b); //using value besides the block 

	}
}
