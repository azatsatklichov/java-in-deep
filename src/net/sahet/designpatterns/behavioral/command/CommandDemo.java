package net.sahet.designpatterns.behavioral.command;

public class CommandDemo {
	public static void main(String[] args) {
		System.out.println("\n	Command design patterns Java ");
		// junit.textui.TestRunner.run(CommandPattern.class);

		Macro macro = new Macro();
		macro.add(new Hello());
		macro.add(new World());
		macro.add(new IAm());
		macro.run();

		System.out.println("\n\n	Command Java build-in classes ");
		/**
		 * java.lang.Runnable
		 * 
		 * javax.swing.action.Action
		 * 
		 */
		ToDo taskA = new ToDo(4, 7);
		ToDo taskB = new ToDo(6, 37);

		Thread t1 = new Thread(taskA);
		t1.start();

		Thread t2 = new Thread(taskB);
		t2.start();
	}
}

class ToDo implements Runnable {
	int a;
	int b;

	public ToDo(int a, int b) {
		this.a = a;
		this.b = b;
	}

	@Override
	public void run() {
		System.out.println(a + b);
	}
}
