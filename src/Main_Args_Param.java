package net.sahet.iviews;

public class Main_Args_Param {

}

class Fork {
	public static void main(String[] args) {
		// so, first check
		System.out.println(" so, first check  args NULLITY");
		/*
		 * if (args == null || args.length==0) { // compile //
		 * System.out.println(null); return; }
		 */

		System.out.println("args: " + args.length);

		if (args.length == 1 | args[1].equals("test")) {
			System.out.println("test case");
		} else {
			System.out.println("production " + args[0]);
		}
	}
}

class MainMethodVarArgs {
	public static void main(String[] args) {

		
		if (args == null || args.length == 0) {
			// compile //
			System.out.println(args.length);
			System.out.println("So, args is NOT NULL, all the time, JVM provide empty ARRAY"); 
		}
		
		//NO need to check args == null , because JVM puts empty Array for args

		if ( args.length == 0) {
			// compile //
			System.out.println(args.length);
			System.out.println("So, args is NOT NULL, all the time");
			return;
		}
	}
}
