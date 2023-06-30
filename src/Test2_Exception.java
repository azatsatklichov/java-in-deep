package net.sahet.iviews;

public class Test2_Exception {

}

class Emu {
	static String s = "-";

	public static void main(String[] args) {
		try {
			throw new Exception();
		} catch (Exception e) {
			try {
				try {
					throw new Exception();
				} catch (Exception ex) {
					s += "ic ";
				}
				System.out.println("--- ");
				throw new Exception();
			} catch (Exception x) {
				s += "mc ";
			} finally {
				s += "mf ";
			}
		} finally {
			s += "of ";
		}
		System.out.println(s);
	}
}

// 2-example
/**
 * What is the result? (Choose all that apply.)
 * 
 * A. Compilation succeeds
 * 
 * B. Compilation fails due to an error on line 8
 * 
 * C. Compilation fails due to an error on line 10  === issue
 * 
 * D. Compilation fails due to an error on line 12
 * 
 * E. Compilation fails due to an error on line 14
 * 
 * 
 */
class SubException extends Exception {
}

class SubSubException extends SubException {
}

class CC {
	void doStuff() throws SubException {
	}
}

class CC2 extends CC {
	void doStuff() throws SubSubException {
	}
}

//line 10
class CC3 extends CC {
	/*void doStuff() throws Exception { //wider 
	}*/
}

class CC4 extends CC {
	void doStuff(int x) throws Exception { //overloaded method, not overridden 
	}
}

class CC5 extends CC {
	void doStuff() {
	}
}
