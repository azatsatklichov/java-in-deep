package net.sahet.designpatterns.behavioral.memento;

import java.util.Stack;

public class TaskCaretaker {

	private Stack<TaskMemento> taskHistory = new Stack<>();

	public void create(Task job) {
		taskHistory.push(job.create());
	}

	public void revert(Task task) {
		TaskMemento prevState = taskHistory.pop();
		task.revert(prevState);
	}
}
