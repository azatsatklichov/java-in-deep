package net.sahet.programming.paradigms;



class Parent {
	protected String msg = "I am from Parent";

	public Parent(String input) {
		foo(input);
	}

	public void foo(String input) {
		System.out.println("# " + msg + input);
	}

}

class Child extends Parent {

	protected String msg = "I am from Child";

	public Child(String input) {
		super(input);
		foo(input);
	}
	
	 
}

public class InheritenceOnFields {
	public static void main(String[] args) {
		new Child("X-CertiCn");
		System.out.println("");
	}
}