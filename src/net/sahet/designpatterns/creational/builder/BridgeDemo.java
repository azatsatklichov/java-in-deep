package net.sahet.designpatterns.creational.builder;

public class BridgeDemo {
	public static void main(String[] args) {
		System.out.println("	Telescoping constructor pattern ");
		/**
		 * Safe but not readable
		 * 
		 * Even you do not want, you are forced to set value for all fields. E.g. you
		 * can not setup what you want to build all the time.
		 */
		UserProfileA user1 = new UserProfileA("Merdan", "Orazow");
		System.out.println(user1);

		user1 = new UserProfileA("Merdan", "Orazow", 23);
		System.out.println(user1);
		user1 = new UserProfileA("Merdan", "Orazow", 23, "Happy street 3, London", "333-444-555", "Football");
		System.out.println(user1);

		System.out.println("\n	Java Beans pattern ");
		/**
		 * Readable but not safe
		 * 
		 * 
		 * Huge possibility of making class mutable, object can be corrupted easily via
		 * setters any time.
		 */
		UserProfileB user2 = new UserProfileB();
		user2.setName("Zuleyha");
		user2.setSurname("Kakayewa");
		user2.setAge(29);
		user2.setAddress("Magtymguly 43, Ashgabat");
		user2.setPhone("234-865-543");
		user2.setHobbies("Aydym aytmak");
		System.out.println(user2);

		System.out.println("\n	Builder Design Pattern ");
		/**
		 * Provides both - Safety and Readability
		 * 
		 * Also client can setup (configure) objects via constructor (or static factory)
		 * for required fields and gets a builder object of Static Builder class.
		 * 
		 * Then via setter-kind methods on any optional field can be set.
		 * 
		 */
		UserProfileC.Builder builder = new UserProfileC.Builder("Aziza", "Nizamova");
		UserProfileC user3 = builder.age(63).address("Navoi 47, Tashkent").hobbies("Singing").build();
		System.out.println(user3);

	}
}
