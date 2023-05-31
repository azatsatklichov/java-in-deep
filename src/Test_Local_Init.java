
public class Test_Local_Init {

}

/**
 * What is the result?
 * 
 * <pre>
 * 
 *   A. 2
 *   B. 3
 *   C. 4
 *   D. 5
 *   E. Compilation fails
 *   F. An exception is thrown at runtime
 * </pre>
 * 
 */
class Dark {
	int x = 3;
	Integer i;
	String s;

	public static void main(String[] args) {
		Dark dark = new Dark();
		dark.go1();
		dark.s += 2;
		System.out.println(dark.s);
		
		dark.i+= 2;
		System.out.println(dark.i);

	}

	void go1() {
		int x; /// must be initialized before used
		// go2(++x); // Compilation fails
	}

	void go2(int y) {
		int x = ++y;
		System.out.println(x);
	}
}
