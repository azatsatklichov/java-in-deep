package net.sahet.designpatterns.behavioral.mediator;

import java.util.ArrayList;
import java.util.List;

public class Mediator {

	private List<Application> applications = new ArrayList<>();

	public void registerApplications(List<Application> apps) {
		applications.addAll(apps);
	}

	public void approveAll() {
		applications.stream().filter(a -> !a.isApproved()).forEach(a -> {
			a.toggle();
		});
	}

	public void rejectAll() {
		applications.stream().filter(a -> a.isApproved()).forEach(a -> {
			a.toggle();
		});
	}
}
