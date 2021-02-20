package net.sahet.designpatterns.behavioral.mediator;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MediatorDemo {
	public static void main(String[] args) {
		System.out.println("\n	Mediator design pattern example ");

		Application a1 = new Application();
		Application a2 = new Application();
		Application a3 = new Application();

		Mediator mediator = new Mediator();
		mediator.registerApplications(List.of(a1, a2, a3));
		mediator.registerApplications(Arrays.asList(new Application[] { new Application(), new Application() }));

		Form formsForApproval = new ApproveApplication(mediator);
		formsForApproval.apply();
		System.out.println();

		Form formsForRejection = new RejectApplication(mediator);
		formsForRejection.apply();

		System.out.println("\n	Mediator Java build-in classes ");
		/**
		 * java.util.Timer
		 * 
		 * java.lang.reflect.Method#invoke()
		 * 
		 */
		TimerTask task = new TimerTask() {
			public void run() {
				System.out.println("Task executed by" + Thread.currentThread().getName() + " at: " + new Date());
			}
		};
		Timer timer = new Timer("Timer");
		timer.schedule(task, 2000L);

	}
}
