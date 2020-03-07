package net.sahet.designpatterns.creational.prototype;

/**
 * Client Class
 */
public class PrototypeDemo {

	private PrototypeFactory prototype;

	public PrototypeDemo(PrototypeFactory prototype) {
		this.prototype = prototype;
	}

	public PrototypeFactory makeCopy() throws CloneNotSupportedException {
		return this.prototype.clone();
	}

	public static void main(String args[]) {
		System.out.println("\n	Prototype Pattern example");
		try {
			PrototypeFactory prototype = null;
			int num = 1000;
			PrototypeFactory prot = new PrototypeImpl(1000);
			PrototypeDemo cm = new PrototypeDemo(prot);
			for (int i = 0; i < 10; i++) {
				prototype = cm.makeCopy();
				prototype.prototypeFactory(i * num);
				prototype.printValue();
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}

//simple Java example
class Jest implements Cloneable {
	int id;
	String name;

	Jest(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public static void main(String args[]) {

		System.out.println("\n	Prototype Java build-in classes ");
		/**
		 * Object#clone() - provides shallow copy
		 * 
		 * If you want deep-copy the use copy-constructor approach
		 * 
		 */
		try {
			Jest j1 = new Jest(23, "Cemen");

			Jest j2 = (Jest) j1.clone();

			System.out.println(j1.id + " " + j1.name);
			System.out.println(j2.id + " " + j2.name);

			if (j1 != j2) {
				System.out.println("Not same objects");
			}

		} catch (CloneNotSupportedException e) {
			System.err.println("Error during cloning: " + e);
		}

	}
}