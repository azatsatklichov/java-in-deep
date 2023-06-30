package net.sahet.iviews;

/**
 * Propagating Uncaught Exceptions
 * 
 * <pre>
 * 
 * Why aren't catch clauses required? What happens to an exception that's thrown 
 * in a try block when there is no catch clause waiting for it? Actually, there's no 
 * requirement that you code a catch clause for every possible exception that could 
 * be thrown from the corresponding try block. In fact, it's doubtful that you could 
 * accomplish such a feat! 
 * 
 * If a method doesn't provide a catch clause for a particular 
 * exception, that method is said to be "ducking" the exception (or "passing the buck").
 * So what happens to a ducked exception? Before we discuss that, we need to 
 * briefly review the concept of the call stack. 
 * 
 * Most languages have the concept of 
 * a method stack or a call stack. Simply put, the call stack is the chain of methods 
 * that your program executes to get to the current method. If your program starts in 
 * method main() and main() calls method a(), which calls method b(), which in 
 * turn calls method c(), the call stack consists of the following:
 * 
 * c
 * b
 * a
 * main
 * 
 * </pre>
 * 
 * Propagating and Catching an Exception
 * 
 * 
 * In this exercise you're going to create two methods that deal with
 * exceptions. One of the methods is the main() method, which will call another
 * method. If an exception is thrown in the other method, main() must deal with
 * it. A finally statement will be included to indicate that the program has
 * completed. The method that main() will call will be named reverse, and it
 * will reverse the order of the characters in a String. If the String contains
 * no characters, reverse will propagate an exception up to the main() method.
 * 
 */
public class Exception_Propogation {

}

class Ping extends Utils {
	public static void main(String[] args) throws Exception { //Propogating exception
		Utils u = new Ping();
		System.out.print(u.getInt(args[0]));
	}

	int getInt(String arg) { //implicitly owns exception from parent 
		return Integer.parseInt(arg);
	}
}

class Utils {
	int getInt(String x) throws Exception {
		return 7;
	}
}