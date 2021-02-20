package net.sahet.designpatterns.structural.flyweight;

public class Heavy {
	private final String name;

	public Heavy(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
