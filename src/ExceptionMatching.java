package net.sahet.iviews;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Exception Matching
 * 
 * <pre>
 * If you have an exception hierarchy composed of a superclass exception and a
 * number of subtypes, and you're interested in handling one of the subtypes in
 * a special way but want to handle all the rest together, you need write only
 * two catch clauses. 
 * 
 * When an exception is thrown, Java will try to find (by
 * looking at the available catch clauses from the top down) a catch clause for
 * the exception type. If it doesn't find one, it will search for a handler for
 * a supertype of the exception. 
 * 
 * If it does not find a catch clause that matches
 * a supertype for the exception, then the exception is propagated down the call
 * stack. This process is called exception matching. Let's look at an example:
 * </pre>
 * 
 */
public class ExceptionMatching {

}

class ReadData {
	public static void main(String args[]) {
		try {
			RandomAccessFile raf = new RandomAccessFile("myfile.txt", "r");
			byte b[] = new byte[1000];
			raf.readFully(b, 0, 1000);

			/**
			 * FileNotFoundException is a subclass of IOException. Therefore, we
			 * could handle it in the catch clause that catches all subtypes of
			 * IOException, but then we would have to test the exception to
			 * determine whether it was a FileNotFoundException. Instead, we
			 * coded a special exception handler for the FileNotFoundException
			 * and a separate exception handler for all other IOException
			 * subtypes.
			 */
		} catch (FileNotFoundException e) {
			System.err.println("File not found");
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("IO Error");
			System.err.println(e.toString());
			e.printStackTrace();
		}
		
		
		/*
		 * Notice that the catch clause for the FileNotFoundException was placed
		 * above the handler for the IOException. This is really important! If
		 * we do it the opposite way, the program will not compile. The handlers
		 * for the most specific exceptions must always be placed above those
		 * for more general exceptions. The following will not compile:
		 */
		
	/*	try {
		  // do risky IO things
		} catch (IOException e) {
		  // handle general IOExceptions
		} catch (FileNotFoundException ex) {
		  // handle just FileNotFoundException
		}*/
		
		
	}
}
