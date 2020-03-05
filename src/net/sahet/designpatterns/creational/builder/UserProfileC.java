package net.sahet.designpatterns.creational.builder;

/**
 * UserProfile via Builder Design Pattern.
 * 
 * If you have a lot parameters in a aclass then Builder pattern is a good
 * choice.
 * 
 * 
 * <pre>
* * Pros(+) and Cons(-)
 * 
 * + Combines both Safety and Readability from UserProfiles A and B
 * 
 * + You can setup (configure) your object as you wish
 * 
 * + [from J. Bloch] Builder pattern simulates named optional parameters as found in Ada and Python
 * 
 * + [from J. Bloch] A minor advantage of builders over constructors is that builders can have multiple
	varargs parameters. Constructors, like methods, can have only one varargs
	parameter. Because builders use separate methods to set each parameter, they can
	have as many varargs parameters as you like, up to one per setter method.
 * 
 * - To create object, you need to create builder first. If cost of creating Builder object is 
 * heavy then it causes performance problems. 
 * 
 * - Builder pattern is also verbose like  telescoping  constructor pattern,  
 * better use it if you have more parameters e.g. more than 5.
 * 
 * - Immutable (sometimes good, sometimes not ;) )
 *
 * </pre>
 */
public class UserProfileC {
	private final String name;
	private final String surname;
	private final int age;

	private final String address;
	private final String phone;
	private final String hobbies;

	/**
	 * You can make more null-safe this, via Java 8 Optional
	 *
	 */
	public static class Builder {
		// required fields (final)
		private final String name;
		private final String surname;

		// optional fields (non final)
		private int age;
		private String address;
		private String phone;
		private String hobbies;

		/**
		 * Constructor is just for required fields
		 *
		 */
		public Builder(String name, String surname) {
			if (name == null || surname == null) {
				throw new IllegalArgumentException("Required fields can not be null.");
			}
			this.name = name;
			this.surname = surname;
		}

		/**
		 * Setter-like methods for optional fields.
		 * 
		 * Builder pattern simulates named optional parameters as found in Ada and
		 * Python
		 */
		public Builder age(int age) {
			this.age = age;
			return this;
		}

		public Builder address(String address) {
			this.address = address;
			return this;
		}

		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public Builder hobbies(String hobbies) {
			this.hobbies = hobbies;
			return this;
		}

		public UserProfileC build() {
			return new UserProfileC(this);
		}

	}

	/**
	 * Provide constructor for Builder usage
	 * 
	 * @param builder
	 */
	public UserProfileC(Builder builder) {
		this.name = builder.name;
		this.surname = builder.surname;
		this.age = builder.age;
		this.address = builder.address;
		this.phone = builder.phone;
		this.hobbies = builder.phone;
	}

	@Override
	public String toString() {
		return "Hello from " + this.getClass().getSimpleName() + "#" + hashCode();
	}
}
