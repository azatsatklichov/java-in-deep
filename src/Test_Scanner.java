package net.sahet.iviews;

import java.util.Scanner;

/**
 * Searching Using the Scanner Class
 * 
 * Although the java.util.Scanner class is primarily intended for tokenizing
 * data (which we'll cover next), it can also be used to find stuff, just like
 * the Pattern and Matcher classes. While
 * 
 * 
 * Scanner doesn't provide location information or search and replace
 * functionality, you can use it to apply regex expressions to source data to
 * tell you how many instances of an expression exist in a given piece of source
 * data.
 * 
 * The following program uses the first command-line argument as a regex
 * expression, then asks for input using System.in. It outputs a message every
 * time a match is found:
 * 
 * 
 * <p>
 * The invocation and input
 * </p>
 * 
 * <pre>
 * 
 * java ScanIn "\d\d"
 * input: 1b2c335f456
 * </pre>
 * 
 * 
 */
public class Test_Scanner {
	public static void main(String[] args) {
		System.out.print("input: ");
		System.out.flush();
		try {
			Scanner s = new Scanner(System.in);
			String token;
			do {
				token = s.findInLine(args[0]);
				System.out.println("found " + token);
			} while (token != null);
		} catch (Exception e) {
			System.out.println("scan exc");
		}
	}

}


