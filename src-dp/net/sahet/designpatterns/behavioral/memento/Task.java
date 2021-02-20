package net.sahet.designpatterns.behavioral.memento;

public class Task {

	private String name;
	private String desc;

	public TaskMemento create() {
		return new TaskMemento(name, desc);
	}

	public void revert(TaskMemento task) {
		this.name = task.getName();
		this.desc = task.getDesc();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String toString() {
		return "Job [name = " + name + ", desc = " + desc + "]";
	}

}
