package net.sahet.iviews;

public class Test_Overloading {

}

class Alien {
	String invade(short ships) {
		return "a few";
	}

	String invade(short... ships) {
		return "many";
	}
}

class Defender2 {
	public static void main(String[] args) {
		// compilation error
		// DEMOTION(downcast) must be EXPLICIT
		// System.out.println(new Alien().invade(7));
	}
}

class Alie2n {
	String invade(short ships) {
		return "a few";
	}

	String invade(short... ships) {
		return "many";
	}
}

class Defende2r  {
	public static void main(String[] args) {
		short s = 7;
		short s2 = (short)7;
		
		///but for methods COMPILER does not HELP
		//System.out.println(new Alien().invade(7));
		System.out.println(new Alien().invade((short)7));
	}
}
