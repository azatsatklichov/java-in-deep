
//form thinking in Java
package net.sahet.designpatterns.behavioral.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import junit.framework.TestCase;

interface Command {
	void execute();
}

class Hello implements Command {
	public void execute() {
		System.out.print("Hello ");
	}
}

class World implements Command {
	public void execute() {
		System.out.print("World! ");
	}
}

class IAm implements Command {
	public void execute() {
		System.out.print("I'm the command pattern!");
	}
}
 
class Macro {
	private List commands = new ArrayList();

	public void add(Command c) {
		commands.add(c);
	}

	public void run() {
		Iterator it = commands.iterator();
		while (it.hasNext())
			((Command) it.next()).execute();
	}
}

public class CommandPattern extends TestCase {
	Macro macro = new Macro();

	public void test() {
		macro.add(new Hello());
		macro.add(new World());
		macro.add(new IAm());
		macro.run();
	}

	public static void main(String args[]) {
		junit.textui.TestRunner.run(CommandPattern.class);
	}
} // /:~
