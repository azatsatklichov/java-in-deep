package net.sahet.iviews;

public class OverloadingCombination_BoxThenWiden {

}

/**
 * 
 * 
 * 
 * <p>
 * Overloading When Combining Widening and Boxing :
 * </p>
 * 
 * <pre>
 * We've looked at the rules that apply when the compiler can match an
 * invocation 
 * to a method by performing a single conversion. 
 * 
 * Now let's take a  look at what happens 
 * when more than one conversion is required. 
 * 
 * In this case the compiler will have to widen and then autobox 
 * the parameter for a match to  be made
 * 
 * </pre>
 */
class WidenThenBoxing_isIllegal {
	static void go(Long x) {
		System.out.println("Long");
	}

	public static void main(String[] args) {
		byte b = 5;
		// go(b); // must widen then box - illegal
	}
}

/*
 * Strangely enough, it IS possible for the compiler to perform a boxing
 * operation followed by a widening operation
 * 
 * in order to match an invocation to a method. This one might blow your mind:
 */
class BoxingThenWiden_isOK {
	/**
	 * The key point here is that reference widening depends on inheritance, in
	 * other words the IS-A test.
	 * 
	 * Because of this, it's not legal to widen from one wrapper class to
	 * another, because the wrapper classes are peers to one another. For
	 * instance, it's NOT valid to say that Short IS-A Integer
	 * 
	 * @param o
	 */
	static void go(Object o) {
		// here then we can use as we want
		Byte b2 = (Byte) o; // ok - it's a Byte object
		System.out.println(b2);

		// or if we want Long
		Long l2 = (Long) o; // ok - it's a Byte object
		System.out.println(b2);
	}

	/**
	 * 
	 * <p>
	 * Desc: Here's what happened under the covers when the compiler, then the
	 * JVM, got to the line that invokes the go() method:
	 * </p>
	 * 
	 * <pre> 
	 *  1. The byte b was boxed to a Byte.
	 *  2. The Byte reference was widened to an Object (since Byte extends Object).
	 *  3. The go() method got an Object reference that actually refers to a Byte 
	 * object.
	 *  4. The go() method cast the Object reference back to a Byte reference (re 
	 * member, there was never an object of type Object in this scenario, only an 
	 * object of type Byte!).
	 *  5. The go() method printed the Byte's value.
	 * </pre>
	 * 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		byte b = 5;
		go(b); // can this byte turn into an Object ?
		// YES, // byte-->Byte-->Object
		// 1-Boxing, then 2-Widen (reference widen)
	}
}
