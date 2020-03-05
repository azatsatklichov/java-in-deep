package net.sahet.designpatterns.creational.singleton;

public class SingletonDemo {
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

		System.out.println("\n	Java Singleton build-in classes ");
		/**
		 * Logger
		 * 
		 * Runtime
		 * 
		 * Spring Beans (by default singletons)
		 * 
		 * Graphic Managers
		 * 
		 * Calendar is not a Singleto, not confuse with getInstance()
		 * 
		 */
		Runtime runtime1 = Runtime.getRuntime();
		runtime1.gc();
		System.out.println(runtime1);
		Runtime runtime2 = Runtime.getRuntime();
		System.out.println(runtime2);
		if (runtime1 == runtime2) {
			System.out.println("Indeed they are the same instance");
		}
	}
}
