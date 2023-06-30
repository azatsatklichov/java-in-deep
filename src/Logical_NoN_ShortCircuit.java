package net.sahet.iviews;

/**
 * Logical Operators (Not Short-Circuit) There are two non-short-circuit logical
 * operators.
 * 
 * 
 * ■ & non-short-circuit AND (checks all conditions )
 * 
 * 
 * ■ | non-short-circuit OR (checks all conditions )
 * 
 * 
 * These operators are used in logical expressions just like the && and ||
 * operators are used, but because they aren't the short-circuit operators, they
 * evaluate both sides of the expression, always! They're inefficient. For
 * example, even if the first operand (left side) in an & expression is false,
 * the second operand will still be evaluated� even though it's now impossible
 * for the result to be true! And the | is just as inefficient: if the first
 * operand is true, the JVM still plows ahead and evaluates the second operand
 * even when it knows the expression will be true regardless.
 * 
 */
public class Logical_NoN_ShortCircuit {
	public static void main(String[] args) {
		int x = 2;
		int y = 3;
		// non-shortcut operator (checks all conditions )
		System.out.println("non-shortcut operator");
		if ((y == x++) | (x < ++y)) {
			System.out.println("x = " + x + " y = " + y);
		}

		// non-shortcut operator, (checks all conditions )
		int z2 = 5;
		if (++z2 > 5 | ++z2 > 6)
			z2++; // z2 = 8 after this code
		System.out.println("z2 = " + z2);

		System.out.println("\nshortcut operator");
		int z = 5;
		// shortcut operator
		if (++z > 5 || ++z > 6)
			z++; // z = 7 after this code
		System.out.println(z);

	}

}

class Titanic {
	public static void main(String[] args) {
		Boolean b1 = true;
		boolean b2 = false;
		boolean b3 = true;
		if ((b1 & b2) | (b2 & b3) & b3)
			System.out.print("alpha ");
		if ((b1 = false) | (b1 & b3) | (b1 | b2))
			System.out.print("beta ");

		// No output is produced.
	}
}

class AssignmentOps {
	public static void main(String[] args) {
		int sizeOfYard = 10;
		int numOfPets = 3;
		String status = (numOfPets < 4) ? "Pet count OK"
				: (sizeOfYard > 8) ? "Pet limit on the edge" : "too many pets";
		System.out.println("Pet status is " + status);
	}
}
