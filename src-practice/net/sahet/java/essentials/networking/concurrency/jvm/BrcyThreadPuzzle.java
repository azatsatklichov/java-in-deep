package net.sahet.java.essentials.networking.concurrency.jvm;

public class BrcyThreadPuzzle {

	public static void main(String[] args) {
		BrclThread t1 = new BrclThread();
		t1.setName("Thread-A");
		BrclThread t2 = new BrclThread();
		t2.setName("Thread-B");

		try {
			// t1.run();
			// t2.run();
			t1.start();
			t1.join();
			System.out.println("Main thread");
			System.out.println("T1 - is 100% finished, isAlive = " + t1.isAlive());
			t2.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("done, here order may not be guaranteed, becase t2 is not joined into main thread");
		System.out.println(t1.i); // 1000 all time
		System.out.println(t2.i);// different each time
	}
}

class BrclThread extends Thread {
	static int i = 0;

	@Override
	public void run() {
		for (int k = 0; k < 1000; k++) {
			++i;
		}
		System.out.println(Thread.currentThread().getName());
		System.out.println("i = " + i);
	}
}