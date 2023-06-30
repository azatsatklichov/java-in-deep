package net.sahet.iviews;

/**
 * A case constant must evaluate to the same type as the switch expression can
 * use, with one additional�and big�constraint: the case constant must be a
 * compile time constant! Since the case argument has to be resolved at compile
 * time, that means you can use only a constant or final variable that is
 * assigned a literal value. It is not enough to be final, it must be a compile
 * time constant. For example:
 * 
 */
public class Switch_CompileTime_Contstant {
	
	static final int bb  = 9;

	public static void main(String[] args) {
		final int a = 1; // Compile time assignment
		final int b;  //causes problem in switch statement, even thought it is FINAL
		
		
		b = 2; // Runtime assignment
		int x = 0;
		switch (x) {
		case a: // ok
		//case b: // compiler error
		case bb:  // OH fine
		}
	}
}
