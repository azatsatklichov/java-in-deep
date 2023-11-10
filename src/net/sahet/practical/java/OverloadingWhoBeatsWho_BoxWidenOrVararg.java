package net.sahet.practical.java;

/**
 * Because, once again, even though each invocation will require some sort of
 * conversion, the compiler will choose the older style before it chooses the
 * newer style, keeping existing code more robust. So far we've seen that
 * 
 * - Widening beats boxing
 * 
 * - Widening beats var-args
 * 
 * - Boxing beats var-args()
 * 
 * - so looser is VarArgs, and winner is Widening
 */

class WideningOrBoxing {

	/**
	 * As we've seen earlier, if the only version of the go() method was one that
	 * took an Integer, then Java 5's boxing capability would allow the invocation
	 * of go() to succeed. Likewise, if only the long version existed, the compiler
	 * would use it to handle the go() invocation. The question is, given that both
	 * methods exist, which one will be used? In other words, does the compiler
	 * think that widening a primitive parameter is more desirable than performing
	 * an autoboxing operation? The answer is that the compiler will choose widening
	 * over boxing, so the output will be
	 * 
	 * 
	 * long
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int i = 5;
		go(i); // which go() will be invoked?
		// The answer is that the compiler will choose widening over boxing, so
		// the output will be long
		/**
		 * the compiler will choose the older style before it chooses the newer style,
		 * keeping existing code more robust.
		 */

		// - Widening beats boxing
	}

	static void go(Integer x) {
		System.out.println("Integer");
	}

	static void go(long x) {
		System.out.println("long");
	}
}

/*
 * Java 5's designers decided that the most important rule should be that
 * pre-existing code should function the way it used to, so since widening
 * capability already existed, a method that is invoked via widening shouldn't
 * lose out to a newly created method that relies on boxing. Based on that rule,
 * try to predict the output of the following:
 */
class WideningOrVarargs {
	public static void main(String[] args) {
		byte b = 5;
		go(b, b); // which go() will be invoked?
		/*
		 * Because, once again, even though each invocation will require some sort of
		 * conversion, the compiler will choose the older style before it chooses the
		 * newer style, keeping existing code more robust. So far we've seen that
		 * 
		 */
	}

	static void go(int x, int y) {
		System.out.println("int,int");
	}

	static void go(byte... x) {
		System.out.println("byte... ");
	}
}

class BoxOrVararg {
	public static void main(String[] args) {
		byte b = 5;
		go(b, b); // which go() will be invoked?
		// - Boxing beats var-args()

		// var-args method is "looser" than the other method

	}

	static void go(Byte x, Byte y) {
		System.out.println("Byte, Byte");
	}

	static void go(byte... x) {
		System.out.println("byte... ");
	}
}

/////////////////

class Overloading_BoxThenWiden {
	int doX(Long x, Long y) {
		return 1;
	}

	int doX(long... x) {
		return 2;
	}

	int doX(Integer x, Integer y) {
		return 3;
	}

	int doX(Number n, Number m) {
		return 4;
	}

	public static void main(String[] args) {
		new Overloading_BoxThenWiden().go();
	}

	void go() {
		short s = 7;
		System.out.print(doX(s, s) + " "); // short-->Short subclass of Number
											// //Box then Widen
		System.out.println(doX(7, 7)); // int-->Integer

		/*
		 * oTwo rules apply to the first invocation of doX(). You can�t widen and then
		 * box in one step, and var-args are always chosen last. Therefore you can�t
		 * widen shorts to either ints or longs, and then box them to Integers or Longs.
		 * But you can box shorts to Shorts and
		 */
	}
}

/////////

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
class Overloading_Widening {

	/**
	 * 
	 * 
	 * 
	 * In every case, when an exact match isn't found, the JVM uses the method with
	 * the smallest argument that is wider than the the parameter
	 * 
	 * 
	 * - Widening - Autoboxing - Var-args
	 */

	/*
	 * When a class has overloaded methods, one of the compiler's jobs is to
	 * determine which method to use whenever it finds an invocation for the
	 * overloaded method. Let's look at an example that doesn't use any new Java 5
	 * features:
	 */

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

////

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
	 * Because of this, it's not legal to widen from one wrapper class to another,
	 * because the wrapper classes are peers to one another. For instance, it's NOT
	 * valid to say that Short IS-A Integer
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
	 * Desc: Here's what happened under the covers when the compiler, then the JVM,
	 * got to the line that invokes the go() method:
	 * </p>
	 * 
	 * <pre>
	 *  
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

/////////////

/**
 * As we can see in Vararg_With_Either_Widening_Or_Boxing, you can successfully
 * combine var-args with either widening or boxing. Here's a review of the rules
 * for overloading methods using widening, boxing, and var-args:
 * 
 * <pre>
 * 
 * ■ Primitive widening uses the "smallest" method argument possible.
 * 
 * ■ Used individually, boxing and var-args are compatible with overloading.
 * 
 * ■ You CANNOT widen from one wrapper type to another. (IS-A fails.)
 * 
 * ■ You CANNOT widen and then box. (An int can't become a Long.)
 * 
 * ■  You can box and then widen. (An int can become an Object, via Integer.)
 * 
 * ■ You can combine var-args with either widening or boxing.
 * </pre>
 * 
 */
class OverloadingCombination_Varargs_With_Either_Widening_Or_Boxing {

}

/**
 * What happens when we attempt to combine var-args with either widening or
 * boxing in a method-matching scenario? Let's take a look:
 */
class Vararg_With_Either_Widening_Or_Boxing {

	// NOTE, here if we use same method name, then compiler error AMBIGUITY
	static void wide_vararg(long... x) {
		System.out.println("long...");
	}

	static void box_vararg(Integer... x) {
		System.out.println("Integer...");
	}

	public static void main(String[] args) {
		int i = 5;
		wide_vararg(5, 5); // needs to widen and use var-args
		box_vararg(5, 5); // needs to box and use var-args
	}
}
/*
 * This compiles and produces: long... Integer...
 */
