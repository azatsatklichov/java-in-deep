package net.sahet.designpatterns.creational.singleton;

public class Demo {
	public static void main(String[] args) {
		System.out.println("	Non thread safe Singleton ");
		ThreadNonSafeSingleton singleton1 = ThreadNonSafeSingleton.getInstance();
		System.out.println(singleton1);

		singleton1 = ThreadNonSafeSingleton.getInstance();
		System.out.println(singleton1);

		System.out.println("\n	Thread safe Singleton ");
		ThreadSafeSingleton singleton2 = ThreadSafeSingleton.getInstance();
		System.out.println(singleton2);

		singleton2 = ThreadSafeSingleton.getInstance();
		System.out.println(singleton2);

		System.out.println("\n	Thread safe enum  Singleton ");
		EnumSingleton singleton3 = EnumSingleton.INSTANCE;
		System.out.println(singleton3);

		singleton3 = EnumSingleton.INSTANCE;
		System.out.println(singleton3);
	}
}
