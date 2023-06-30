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
public class OverloadingCombination_Varargs_With_Either_Widening_Or_Boxing {

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
