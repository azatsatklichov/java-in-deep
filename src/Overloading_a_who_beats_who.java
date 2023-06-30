package net.sahet.iviews;

/**
 * Because, once again, even though each invocation will require some sort of
 * conversion, the compiler will choose the older style before it chooses the
 * newer style, keeping existing code more robust. So far we've seen that
 * 
 * - Widening beats boxing - Widening beats var-args
 */

class WideningOrBoxing {
	static void go(Integer x) {
		System.out.println("Integer");
	}

	static void go(long x) {
		System.out.println("long");
	}

	/**
	 * As we've seen earlier, if the only version of the go() method was one
	 * that took an Integer, then Java 5's boxing capability would allow the
	 * invocation of go() to succeed. Likewise, if only the long version
	 * existed, the compiler would use it to handle the go() invocation. The
	 * question is, given that both methods exist, which one will be used? In
	 * other words, does the compiler think that widening a primitive parameter
	 * is more desirable than performing an autoboxing operation? The answer is
	 * that the compiler will choose widening over boxing, so the output will be
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

		// - Widening beats boxing
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
	static void go(int x, int y) {
		System.out.println("int,int");
	}

	static void go(byte... x) {
		System.out.println("byte... ");
	}

	public static void main(String[] args) {
		byte b = 5;
		go(b, b); // which go() will be invoked?
		/*
		 * Because, once again, even though each invocation will require some
		 * sort of conversion, the compiler will choose the older style before
		 * it chooses the newer style, keeping existing code more robust. So far
		 * we've seen that
		 * 
		 * - Widening beats boxing
		 * 
		 * - Widening beats var-args
		 * 
		 * 
		 * - Boxing beats var-args()
		 */
	}
}

class BoxOrVararg {
	static void go(Byte x, Byte y) {
		System.out.println("Byte, Byte");
	}

	static void go(byte... x) {
		System.out.println("byte... ");
	}

	public static void main(String[] args) {
		byte b = 5;
		go(b, b); // which go() will be invoked?
		// - Boxing beats var-args()

		// var-args method is "looser" than the other method

	}
}
