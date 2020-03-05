package net.sahet.designpatterns.creational.builder;

/**
 * UserProfile via simple Java Beans pattern - POJO
 * 
 * <pre>
*Pros(+) and Cons(-)
 * 
 * + simple POJO implementation, just provide geters and setters
 * 
 * + readable
 * 
 * - a lot setters, no different between required or optional fields
 * 
 * - mutable object, you can change the state of object any time
 * 
 * - allows inconsistency
 * </pre>
 */
public class UserProfileB {
	// required fields
	private String name;
	private String surname;

	// optional fields
	private int age;
	private String address;
	private String phone;
	private String hobbies;

	// implicit (nor-arg) constructor is provided by Java Compiler

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	@Override
	public String toString() {
		return "Hello from " + this.getClass().getSimpleName() + "#" + hashCode();
	}
}
