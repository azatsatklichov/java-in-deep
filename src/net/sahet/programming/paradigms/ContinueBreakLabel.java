package net.sahet.programming.paradigms;

public class ContinueBreakLabel {

}

class Circus {
	public static void main(String[] args) {
		int x = 9;
		int y = 6;
		for (int z = 0; z < 6; z++, y--) {
			if (x > 2)
				x--;
			label: if (x > 5) {
				System.out.print(x + " ");
				--x;
			//	continue label; //compile error
			}
			x--;
		}
	}
}
