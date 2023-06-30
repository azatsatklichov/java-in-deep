package net.sahet.iviews;

/**
 * Legal Expressions for switch and case The general form of the switch
 * statement is:
 * 
 * <pre>
 * 
 * switch (expression) {
 *   case constant1: code block
 *   case constant2: code block
 *   default: code block
 * }
 * 
 * 
 * A switch's expression must evaluate to a char, byte, short, int, or, as of Java 
 * 6, an enum, Java 7 String.  That means if you're not using an enum, only variables and values 
 * that can be automatically promoted (in other words, implicitly cast) to an int are 
 * acceptable. You won't be able to compile if you use anything else, including the 
 * remaining numeric types of long, float, and double.
 * 
 * 
 * A case constant must evaluate to the same type as the switch expression can 
 * use, with one additional—and big—constraint: the case constant must be a 
 * compile time constant! Since the case argument has to be resolved at compile 
 * time, that means you can use only a constant or final variable that is assigned a 
 * literal value. It is not enough to be final, it must be a compile time constant. For 
 * example:
 * 
 * 
 * final int a = 1;
 * final int b;
 * b = 2;
 * int x = 0;
 * switch (x) {
 *   case a:     // ok
 *   case b:     // compiler error
 * </pre>
 * 
 */
public class SwithLegalExpressionForSwitchAndCase {

	public static void main(String[] args) {

		final int a = 1;
		final int b; /// no compiler time constant 
		b = 2;
		int x = 0;
		switch (x) {
		case a: // ok
//		case b: // compiler error
		}
		
		
		/*
		 * Also, the switch can only check for equality. This means that the
		 * other relational operators such as greater than are rendered unusable
		 * in a case. The following is an example of a valid expression using a
		 * method invocation in a switch statement. Note that for this code to
		 * be legal, the method being invoked on the object reference must
		 * return a value compatible with an int.
		 */
		String s = "xyz";
		switch (s.length()) {
		  case 1:  
		    System.out.println("length is one");  
		    break;
		  case 2:
		    System.out.println("length is two"); 
		    break;
		  case 3:
		    System.out.println("length is three"); 
		    break;
		  default: 
		    System.out.println("no match");
		}
		
		/*
		 * One other rule you might not expect involves the question, "What
		 * happens if I switch on a variable smaller than an int?" Look at the
		 * following switch:
		 */		
		byte g = 2;
		switch(g) {
		  case 23: 
		//  case 128:  //possible loss of precision
		}
		
		
		/*
		 * It's also illegal to have more than one case label using the same
		 * value. For example, the following block of code won't compile because
		 * it uses two cases with the same value of 80:
		 */
		int temp = 90;
		switch(temp) {
		  case 80 :  System.out.println("80");
	//	  case 80 :  System.out.println("80");   // won't compile! duplicate CASE
		  case 90 :  System.out.println("90");
		  default :  System.out.println("default");
		}
		
		
		/*
		 * It is legal to leverage the power of boxing in a switch expression.
		 * For instance, the following is legal:
		 */
		switch(new Integer(4)) {  // for switch - no need to be compiler-time-constant, but CASE yes
		  case 4: System.out.println("boxing is OK");
		}
		
		//agsam 20-cervenec (Oraza-12), Bx b-n skypeda geplesdim
		//hali kaklamalar bolup dur diydi, 2010 na seyledi, ...
	/*	Look for any violation of the rules for switch and case arguments. 
		For example, you might �? nd illegal examples like the following snippets:*/
		//without COLON
		/*switch(x) {
		  case 0 {
		    y = 7;
		  }
		}*/
		//without case
		/*switch(x) {
		  0: { }
		  1: { }
		}*/
		
		

	}
}
