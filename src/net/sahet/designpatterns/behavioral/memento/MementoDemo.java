package net.sahet.designpatterns.behavioral.memento;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MementoDemo {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		System.out.println("\n	Memento design pattern example ");
		TaskCaretaker taskCaretaker = new TaskCaretaker();

		Task task = new Task();
		task.setName("clean");
		task.setDesc("Office desks");

		taskCaretaker.create(task);
		System.out.println("State after create: " + task);

		task.setDesc("Kitchen and halls");
		taskCaretaker.create(task);
		System.out.println("State after first change: " + task);

		taskCaretaker.revert(task);
		System.out.println("State after first revert" + task);

		taskCaretaker.revert(task);
		System.out.println("State after second revert" + task);

	 
		System.out.println("\n	Memento Java build-in classes ");
		/**
		 * java.util.Date
		 * 
		 * java.io.Serializable
		 * 
		 */
		Job e = new Job("Maysa", 1, 89);
		System.out.println("serialize");
		System.out.println(e);
		try (FileOutputStream fos = new FileOutputStream("emp.ser");
				ObjectOutputStream out = new ObjectOutputStream(fos)) {
			out.writeObject(e);
		}

		System.out.println("de-serialize");
		try (FileInputStream fis = new FileInputStream("emp.ser"); ObjectInputStream in = new ObjectInputStream(fis)) {
			e = (Job) in.readObject();
			System.out.println(e);
		}
	}
}

class Job implements java.io.Serializable {
	public String name;
	public transient int id;
	public int secId;

	public Job(String name, int id, int secId) {
		this.name = name;
		this.id = id;
		this.secId = secId;
	}

	@Override
	public String toString() {
		return "Emp [" + name + ", id = " + id + ", secId = " + secId + "]";
	}

}
