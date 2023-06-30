package net.sahet.iviews;

/**
 * 
 * does NOT waste TIME
 * 
 * 
 * There are five logical operators on the exam that are used to evaluate
 * statements that contain more than one boolean expression. The most commonly
 * used of the five are the two short-circuit logical operators.
 * 
 * Short-Circuit Logical Operators
 * 
 * <pre>
 * 
 * There are five logical operators on the exam that are 
 * used to evaluate statements 
 * that contain more than one boolean expression. 
 * The most commonly used of the 
 * five are the two short-circuit logical operators. 
 * They are
 * 
 * ■  && short-circuit AND  (if first  condition FALSE, then it will not continue)
 * 
 * ■  || short-circuit OR   (if first  condition TRUE, then it will not continue)
 * 
 * They are used to link little boolean expressions together to form bigger boolean 
 * expressions. The && and || operators evaluate only boolean values. For an AND 
 * (&&) expression to be true, both operands must be true—for example,
 * </pre>
 * 
 */
public class Logical_ShortCircuit {
	/**
	 * The short-circuit feature of the && operator is so named because it
	 * doesn't waste its time on pointless evaluations.
	 * 
	 * A short-circuit && evaluates the left side of the operation first
	 * (operand one), and if it resolves to false, the && operator doesn't
	 * bother looking at the right side of the expression (operand two) since
	 * the && operator already knows that the complete expression can't possibly
	 * be true.
	 */
	public static void main(String[] args) {
		boolean b = true && false;
		System.out.println("boolean b = " + b);

		if ((2 < 3) && (3 < 4)) {
			System.out.println(" if ((2 < 3) && (3 < 4)) { } ");
		}

	}
}

class TestOR {
	public static void main(String[] args) {
		//shortcut OR
		if ((isItSmall(3)) || (isItSmall(7))) {
			System.out.println("Result is true");
		}
		
		System.out.println();
		
		if ((isItSmall(6)) || (isItSmall(9))) {
			System.out.println("Result is true");
		}
	}

	public static boolean isItSmall(int i) {
		if (i < 5) {
			System.out.println("i < 5");
			return true;
		} else {
			System.out.println("i >= 5");
			return false;
		}
	}
}
