package net.sahet.iviews;

interface Vessel {
}

interface Toy {
}

class Boat implements Vessel {
}

class Speedboat extends Boat implements Toy {
}

/**
 * What is the result?
 * 
 * <pre> 
 *   A.  0
 *   B.  01
 *   C.  02
 *   D.  012
 *   E. Compilation fails
 *   F. An exception is thrown at runtime 
 * </pre>
 * 
 * 
 * <pre>
 * Answer:
 *      ✓    D is correct. First, remember that instanceof can look up through multiple levels of an 
 * inheritance tree. Also remember that instanceof is commonly used before attempting 
 * a downcast, so in this case, after line 15, it would be possible to say Speedboat s3 = 
 * (Speedboat)b2;.
 *  
 *   
 *   A, B, C, E, and F are incorrect based on the above. (Objective 7.6)
 * </pre>
 * 
 */
class Treex {
	public static void main(String[] args) {
		String s = "0";
		Boat b = new Boat();
		Boat b2 = new Speedboat();
		Speedboat s2 = new Speedboat();
		if ((b instanceof Vessel) && (b2 instanceof Toy))
			s += "1";
		if ((s2 instanceof Vessel) && (s2 instanceof Toy))
			s += "2";
		System.out.println(s);
	}
}
