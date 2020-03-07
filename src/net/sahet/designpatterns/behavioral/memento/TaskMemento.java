package net.sahet.designpatterns.behavioral.memento;

public class TaskMemento {

	private String name;
	private String desc;

	public TaskMemento(String name, String desc) {
		this.name = name;
		this.desc = desc;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}
}
