package net.sahet.iviews;

public class TestStaticGemalto {

}

class Uber {
	static int y = 2;

	Uber(int x) {
		this();
		y = y * 2;
	}

	Uber() {
		y++;
	}
}

class Minor extends Uber {
	Minor() {
		super(y);
		y = y + 3;
	}

	public static void main(String[] args) {
		new Minor();
		System.out.println(y);
	}
}

class DogY {
}

class Beagle extends DogY {
}

class Kennel {
	public static void main(String[] arfs) {
		Beagle b1 = new Beagle();
		DogY dog1 = new DogY();
		DogY dog2 = b1;
		// insert code here
		// Which, inserted at line 9, will compile? (Choose all that apply.)
		Beagle b2 = (Beagle) dog1; // ClassCastException at runtime
		Beagle b3 = (Beagle) dog2;
		// Beagle b4 = dog2; //compile error 
		
		
		//shu yokardaky sowal, b2 u-n GEMALTO da soradylar
		// A and B are correct. However, at runtime, A will throw a ClassCastException because 
		//dog1 refers to a Dog object, which can�t necessarily do Beagle stuff.
	}
}
