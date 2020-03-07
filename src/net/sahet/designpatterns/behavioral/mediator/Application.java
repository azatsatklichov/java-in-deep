package net.sahet.designpatterns.behavioral.mediator;

public class Application {

	private boolean approved;

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public void toggle() {
		if (approved) {
			reject();
		} else {
			approve();
		}
	}

	private void reject() {
		System.out.println("Application rejected");
		approved = false;
	}

	private void approve() {
		System.out.println("Application approved");
		approved = true;
	}
}
