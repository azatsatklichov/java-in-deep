package net.sahet.designpatterns.behavioral.mediator;

public class ApproveApplication implements Form {

	private Mediator mediator;

	public ApproveApplication(Mediator mediator) {
		this.mediator = mediator;
	}

	@Override
	public void apply() {
		mediator.approveAll();
	}
}
