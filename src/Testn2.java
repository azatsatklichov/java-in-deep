package net.sahet.iviews;

class RedwoodT extends TreeT {
	public static void main(String[] args) {
		new RedwoodT().go();
	}

	void go() {
		go2(new TreeT(), new RedwoodT());
		go2((RedwoodT) new TreeT(), new RedwoodT()); // 1-arg
														// java.lang.ClassCastException,
														// ata bala
														// assign--edilip
														// bilinmeyar
	}

	void go2(TreeT t1, RedwoodT r1) {
		RedwoodT r2 = (RedwoodT) t1; // java.lang.ClassCastException, ata bala
										// assign--edilip bilinmeyar
		TreeT t2 = (TreeT) r1;
	}
}

class TreeT {
}

// //////// test 2
class Tenor extends Singer {
	public static String sing() {
		return "fa";
	}

	public static void main(String[] args) {
		Tenor t = new Tenor();
		Singer s = new Tenor();
		System.out.println(t.sing() + " " + s.sing());
	}
}

class Singer {
	public static String sing() {
		return "la";
	}
}
