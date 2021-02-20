package net.sahet.designpatterns.behavioral.mediator;

public class RejectApplication implements Form {

	private Mediator mediator;

	public RejectApplication(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void apply() {
		mediator.rejectAll();
	}
}
