package net.sahet.iviews;

/**
 * <p>
 * Description: Assigning a Literal That Is Too Large for the Variable
 * </p>
 * 
 * <pre>
 * But then what's the result? When you narrow a primitive, Java simply truncates 
 * the higher-order bits that won't fit. In other words, it loses all the bits to the left of 
 * the bits you're narrowing to.
 * Let's take a look at what happens in the preceding code. There, 128 is the bit 
 * pattern 10000000. It takes a full 8 bits to represent 128. But because the literal 128 
 * is an int, we actually get 32 bits, with the 128 living in the right-most (lower-order) 
 * 8 bits. So a literal 128 is actually
 * 00000000000000000000000010000000
 * Take our word for it; there are 32 bits there.
 * To narrow the 32 bits representing 128, Java simply lops off the leftmost (higher-
 * order) 24 bits. We're left with just the 10000000. But remember that a byte is 
 * signed, with the leftmost bit representing the sign (and not part of the value of the 
 * variable). So we end up with a negative number (the 1 that used to represent 128 
 * now represents the negative sign bit). Remember, to find out the value of a negative 
 * number using two's complement notation, you flip all of the bits and then add 1. 
 * Flipping the 8 bits gives us 01111111, and adding 1 to that gives us 10000000, or 
 * back to 128! And when we apply the sign bit, we end up with –128. 
 * 
 * You must use an explicit cast to assign 128 to a byte, and the assignment leaves 
 * you with the value –128. A cast is nothing more than your way of saying to the 
 * compiler, "Trust me. I'm a professional. I take full responsibility for anything weird 
 * that happens when those top bits are chopped off."
 * That brings us to the compound assignment operators. The following will compile,
 * byte b = 3;
 * b += 7;        // No problem - adds 7 to b (result is 10)
 * and is equivalent to
 * byte b = 3;
 * b = (byte) (b + 7);  // Won't compile without the 
 *                      // cast, since b + 7 results in an int
 * The compound assignment operator += lets you add to the value of b, without 
 * putting in an explicit cast. In fact, +=, -=, *=, and /= will all put in an implicit cast.
 * </pre>
 */
public class P_AssigningLiteralhatIsTooLargeForVariable {

	public static void main(String[] args) {
		/*
		 * Assigning a Literal That Is Too Large for the Variable We'll also get
		 * a compiler error if we try to assign a literal value that the
		 * compiler knows is too big to fit into the variable.
		 */

		// byte a = 128; // byte can only hold up to 127
		/*
		 * You must use an explicit cast to assign 128 to a byte, and the
		 * assignment leaves you with the value –128.
		 */
		byte a = (byte) 128; // cast needed

		/*
		 * A cast is nothing more than your way of saying to the compiler,
		 * "Trust me. I'm a professional. I take full responsibility for
		 * anything weird that happens when those top bits are chopped off."
		 * That brings us to the compound assignment operators. The following
		 * will compile,
		 */
		byte b = 3;
		b += 7; // No problem - adds 7 to b (result is 10)

		// but
		/*
		 * The compound assignment operator += lets you add to the value of b,
		 * without putting in an explicit cast. In fact, +=, -=, *=, and /= will
		 * all put in an implicit cast.
		 */
		// b = b +7; //can not, explicit CAST needed

		b = (byte) (b + 7); // Won't compile without the
		// cast, since b + 7 results in an int

		
	}
}
