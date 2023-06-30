package net.sahet.iviews;

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
public class Test_Overloading_3Ways {

}

/**
 * What is the result?
 * 
 * <pre>
 * 
 *    A.  212
 *    B.  232
 *    C.  234
 *    D.  312
 *    E.  332
 *    F.  334
 *    G. Compilation fails
 * </pre>
 * 
 */
class Bertha {
	static String s = "";

	public static void main(String[] args) {
		/**
		 * A is correct.
		 * 
		 * It's legal to autobox and then widen. The first call to doStuff()
		 * boxes the int to an Integer then passes two objects. The second call
		 * cannot widen and then box (making the Long method unusable), so it
		 * boxes the int to an Integer. As always, a var-args method will be
		 * chosen only if no non-var-arg method is possible. The third call is
		 * passing two objects—they are of type 'short array.'
		 * 
		 * 
		 * B, C, D, E, F, and G are incorrect based on the above. (Objective
		 * 3.1)
		 */
		int x = 4;
		Boolean y = true;
		short[] sa = { 1, 2, 3 };
		doStuff(x, y);
		doStuff(x);
		doStuff(sa, sa);
		System.out.println(s);
	}

	static void doStuff(Object o) {
		s += "1";
	}

	static void doStuff(Object... o) {
		s += "2";
	}

	static void doStuff(Integer... i) {
		s += "3";
	}

	static void doStuff(Long L) {
		s += "4";
	}
}