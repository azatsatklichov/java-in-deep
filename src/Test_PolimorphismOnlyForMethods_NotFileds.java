package net.sahet.iviews;

class MammalT {
	String name = "furry ";

	String makeNoise() {
		return "generic noise";
	}
}

class ZebraT extends MammalT {
	String name = "stripes ";

	String makeNoise() {
		return "bray";
	}
}

/**
 * <p>
 * Description: What is the result?
 * </p>
 * 
 * <pre>
 * 
 *    A.  furry bray
 *    B.  stripes bray
 *    C.  furry generic noise
 *    D.  stripes generic noise
 *    E. Compilation fails
 *    F. An exception is thrown at runtime
 * </pre>
 */
class ZooKeeper {
	public static void main(String[] args) {
		new ZooKeeper().go();
	}

	void go() {
		MammalT m = new ZebraT();
		System.out.println(m.name + m.makeNoise());
	}
}
