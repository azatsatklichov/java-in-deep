package net.sahet.designpatterns.creational.builder;

/**
 * UserProfile via Telescoping constructor pattern
 * 
 * <pre>
*Pros(+) and Cons(-)
 * 
 * + You can have a separate constructor for required fields, and increase
 * number of parameters for optional fields with respective constructors
 * 
 * + safe
 * 
 * - mutable mutable object, you can change the state of object any time if you
 * provide setter method
 * 
 * - Still you can not configure your object
 * 
 * - Unreadable once parameters are growing in constructor. Here we have 6
 * parameters, guess if you have 10 or more, and will have a issue with types as
 * well in case you switch the order
 * 
 * - constructor invocation will require many parameters that you don’t want to
 * set, but you’re forced to pass a value for them anyway.
 * 
 * </pre>
 */
public class UserProfileA {
	// required fields
	private final String name;
	private final String surname;

	// optional fields
	private final int age;
	private final String address;
	private final String phone;
	private final String hobbies;

	/**
	 * Just constructor are top-down call
	 *
	 */
	public UserProfileA(String name, String surname) {
		this(name, surname, 0);
	}

	public UserProfileA(String name, String surname, int age) {
		this(name, surname, age, null);
	}

	public UserProfileA(String name, String surname, int age, String address) {
		this(name, surname, age, address, null);
	}

	public UserProfileA(String name, String surname, int age, String address, String phone) {
		this(name, surname, age, address, phone, null);
	}

	public UserProfileA(String name, String surname, int age, String address, String phone, String hobbies) {
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.address = address;
		this.phone = phone;
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "Hello from " + this.getClass().getSimpleName() + "#" + hashCode();
	}
}

/**
 * With this constructor bottom-up approach, you can not use final-fields
 *
 */
class UserProfileA2 {
	// required fields
	private String name;
	private String surname;

	// optional fields
	private int age;
	private String address;
	private String phone;
	private String hobbies;

	/**
	 * Just constructor are bottom-up call
	 *
	 */
	public UserProfileA2(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public UserProfileA2(String name, String surname, int age) {
		this(name, surname);
		this.age = age;
	}

	public UserProfileA2(String name, String surname, int age, String address) {
		this(name, surname, age);
		this.address = address;
	}

	public UserProfileA2(String name, String surname, int age, String address, String phone) {
		this(name, surname, age, address);
		this.phone = phone;
	}

	public UserProfileA2(String name, String surname, int age, String address, String phone, String hobbies) {
		this(name, surname, age, address, phone);
		this.hobbies = hobbies;
	}

}
