package net.sahet.iviews;

/**
 * The Enhanced for Loop (for Arrays)
 * 
 * <pre>
 * 
 *  The enhanced for loop, new to Java 6, is a specialized for loop that simplifies 
 * looping through an array or a collection (which implements ITERABLE interface). In this chapter we're going to focus on 
 * using the enhanced for to loop through arrays. In Chapter 7 we'll revisit the 
 * enhanced for as we discuss collections—where the enhanced for really comes into 
 * its own.
 * 
 * 
 * More formally, let's describe the enhanced for as follows:
 * for(declaration : expression)
 * 
 * The two pieces of the for statement are
 * 
 * ■  declaration The newly declared block variable, of a type compatible with 
 * the elements of the array you are accessing. This variable will be available 
 * within the for block, and its value will be the same as the current array 
 * element.
 * 
 * ■  expression This must evaluate to the array you want to loop through. 
 * This could be an array variable or a method call that returns an array. The 
 * array can be any type: primitives, objects, even arrays of arrays.
 * </pre>
 * 
 */
public class ForEachLoop_Enhanced {

	public static void main(String[] args) {
		/*
		 * Instead of having three components, the enhanced for has two. Let's
		 * loop through an array the basic (old) way, and then using the
		 * enhanced for:
		 */
		int[] a = { 1, 2, 3, 4 };
		System.out.println("\n  basic for loop");
		for (int x = 0; x < a.length; x++)
			// basic for loop
			System.out.print(a[x]);

		System.out.println("\n  enhanced for loop");
		for (int n : a)
			// enhanced for loop
			System.out.print(n);

		// Using definitions, let's look at some legal and illegal e.g.
		int x;
		long x2;
		Long[] La = { 4L, 5L, 6L };
		long[] la = { 7L, 8L, 9L };
		int[][] twoDee = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		String[] sNums = { "one", "two", "three" };
		Animal[] animals = { new Dog(), new Cat() };

		System.out.println("\n legal 'for' declarations");
		// legal 'for' declarations
		for (long y : la)
			; // loop thru an array of longs
		for (long lp : La)
			; // autoboxing the Long objects
				// into longs
		
		for (Long lpp : La); 
		
		for (int[] n : twoDee)
			; // loop thru the array of arrays
		for (int n2 : twoDee[2])
			; // loop thru the 3rd sub-array
		for (String s : sNums)
			; // loop thru the array of Strings
		for (Object o : sNums)
			; // set an Object reference to
				// each String
		for (Animal aa : animals)
			; // set an Animal reference to each
				// element

		System.out.println("\n illegal 'for' declarations");
		// ILLEGAL 'for' declarations
		/**
		 * <pre>
		 * 				for(x2 : la) ;             // x2 is already declared
		 * 				for(int x2 : twoDee) ;     // can't stuff an array into an int
		 * 				for(int x3 : la) ;         // can't stuff a long into an int
		 * 				for(Dog d : animals) ;     // you might get a Cat!
		 * </pre>
		 */

	}
}
