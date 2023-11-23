package net.sahet.java.core.lang.building.blocks;

class AlphaT {
	static String s = " ";

	protected AlphaT() {
		s += "alpha ";
	}
}

class SubAlphaT extends AlphaT {
	private SubAlphaT() { // private constructor can not be visible later, if
							// subclassed
		s += "sub ";
	}
}

class SubSubAlphaT extends AlphaT { // be care, just extending super-parent
	private SubSubAlphaT() {
		s += "subsub ";
	}

	public static void main(String[] args) {
		new SubSubAlphaT();
		System.out.println(s);
	}
}

// / another
class BuildingT {
	BuildingT() {
		System.out.print("b ");
	}

	BuildingT(String name) {
		this();
		System.out.print("bn " + name);
	}
}

class HouseT extends BuildingT {
	HouseT() {
		/// super(); //implicitly added
		System.out.print("h ");
	}

	HouseT(String name) {
		this();
		System.out.print("hn " + name);
	}

	public static void main(String[] args) {
		new HouseT("x ");
	}
}