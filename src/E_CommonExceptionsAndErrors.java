package net.sahet.iviews;

/**
 * 2.6 Recognize situations that will result in any of the following being
 * thrown:
 * 
 * ArrayIndexOutOfBoundsException, ClassCastException, IllegalArgumentException,
 * IllegalStateException, NullPointerException, NumberFormatException,
 * AssertionError, ExceptionInInitializerError, StackOverflowError, or
 * NoClassDefFoundError.
 * 
 * Understand which of these are thrown by the
 * 
 * virtual machine and recognize situations in which others should
 * 
 * 
 * be thrown programmatically.
 * 
 * 
 * <p>
 * let's define two broad categories of exceptions and errors:
 * </p>
 * 
 * <pre>
 * 
 * ■  JVM exceptions Those exceptions or errors that are either exclusively 
 * or most logically thrown by the JVM.
 * 
 * ArrayIndexOutOfBoundsException, ClassCastException, NullPointerException,
 * ExceptionInInitializerError, StackOverflowError, NoClassDefFoundError
 * 
 * 
 * 
 * ■  Programmatic exceptions Those exceptions that are thrown explicitly 
 * by application and/or API programmers.
 * 
 * IllegalArgumentException, IllegalStateException, NumberFormatException,
 * AssertionError
 * 
 * 
 * 
 * </pre>
 * 
 * 
 */
public class E_CommonExceptionsAndErrors {

}

/**
 * JVM Thrown Exceptions
 * 
 * <pre>
 * 
 * Let's start with a very common exception, the NullPointerException. 
 * As we  saw in Chapter 3, this exception occurs when you attempt to access an object 
 * using a reference variable with a current value of null.
 * 
 * 1-example
 * 
 * Surely, the compiler can find the problem with that tiny little program! Nope, 
 * you're on your own. The code will compile just fine, and the JVM will throw a 
 * NullPointerException when it tries to invoke the length() method.
 * 
 * 2-example
 * 
 * Earlier in this chapter we discussed the call stack. As you recall, we used the 
 * convention that main() would be at the bottom of the call stack, and that as 
 * main() invokes another method, and that method invokes another, and so on, 
 * the stack grows upward. Of course the stack resides in memory, and even if your 
 * OS gives you a gigabyte of RAM for your program, it's still a finite amount. 
 * 
 * It's 
 * possible to grow the stack so large that the OS runs out of space to store the call 
 * stack. When this happens you get (wait for it...), a StackOverflowError. 
 * 
 * The 
 * most common way for this to occur is to create a recursive method. A recursive 
 * method is one that invokes itself in the method body. While that may sound 
 * weird, it's a very common and useful technique for such things as searching and 
 * sorting algorithms. 
 * 
 * Take a look at this code:
 * 
 * void go() {    // recursion gone bad
 *    go();
 * }
 * </pre>
 * 
 * As you can see, if you ever make the mistake of invoking the go() method,
 * your program will fall into a black hole; go() invoking go() invoking go(),
 * until, no matter how much memory you have,
 * 
 * you'll get a StackOverflowError.
 * 
 * Again, only the JVM knows when this moment occurs, and the JVM will be the
 * source of this error.
 * 
 */
class JVMThrownExceptions {

}

/**
 * There's no way that the compiler can hope to find these problems before
 * runtime. Let's look at the following:
 * 
 */
class NPE {
	static String s;

	/*
	 * Surely, the compiler can find the problem with that tiny little program!
	 * Nope, you're on your own. The code will compile just fine, and the JVM
	 * will throw a NullPointerException when it tries to invoke the length()
	 * method.
	 */
	public static void main(String[] args) {
		System.out.println(s.length());
	}
}

/**
 * Programmatically Thrown Exceptions
 * 
 * <pre>
 * 
 * Now let's look at programmatically thrown exceptions. Remember we defined 
 * "programmatically" as meaning something like this:
 * 
 *  Created by an application and/or API developer.
 *  
 *  For instance, many classes in the Java API have methods that take String 
 * arguments, and convert these Strings into numeric primitives. A good example 
 * of these classes are the so-called "wrapper classes" that we studied in Chapter 3.
 * 
 * Other examples of programmatic exceptions include an AssertionError (okay,
 * it's not an exception, but it IS thrown programmatically), and throwing an
 * IllegalArgumentException. 
 * 
 * In fact, our mythical API developer could have used
 * IllegalArgumentException for her parseInt() method.
 * 
 * But it turns out that NumberFormatException extends IllegalArgumentException,
 * and is a little more precise, so in this case, using NumberFormatException
 * supports the notion we discussed earlier: that when you have an exception
 * hierarchy, you should use the most precise exception that you can.
 * 
 * 
 * Of course, as we discussed earlier, you can also make up your very own
 * special, custom exceptions, and throw them whenever you want to. These
 * homemade exceptions also fall into the category of
 * "programmatically thrown exceptions."
 * </pre>
 * 
 * 
 * 
 */
class ProgrammaticExceptions {
	public static void main(String[] args) {

	}

	/*
	 * At some point long ago, some programmer wrote the java.lang. Integer
	 * class, and created methods like parseInt() and valueOf(). That programmer
	 * wisely decided that if one of these methods was passed a String that
	 * could not be converted into a number, the method should throw a
	 * NumberFormatException. The partially implemented code might look
	 * something like this:
	 */
	int parseInt(String s) throws NumberFormatException {
		boolean parseSuccess = false;
		int result = 0;
		// do complicated parsing
		if (!parseSuccess) // if the parsing failed
			throw new NumberFormatException();
		return result;
	}

}
