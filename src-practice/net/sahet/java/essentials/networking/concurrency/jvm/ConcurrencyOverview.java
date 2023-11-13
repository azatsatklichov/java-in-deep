package net.sahet.java.essentials.networking.concurrency.jvm;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 * https://www.baeldung.com/java-util-concurrent
 * https://www.baeldung.com/java-concurrency-interview-questions
 *
 * <pre>
 *Main Components
 *
	The java.util.concurrent contains way too many features to discuss in a single write-up. 
	In this article, we will mainly focus on some of the most useful utilities from this package like:
	
	Executor
	ExecutorService
	ScheduledExecutorService
	Future
	CountDownLatch
	CyclicBarrier
	Semaphore
	ThreadFactory
	BlockingQueue
	DelayQueue
	Locks
	Phaser
 * </pre>
 */
public class ConcurrencyOverview {
	public static void main(String[] args) throws InterruptedException, ExecutionException {

		System.out.println("\n custom Executor ");
		// see Invoker
		execute();

		System.out.println("\n   ExecutorService");
		/**
		 * ExecutorService is a complete solution for asynchronous processing. It
		 * manages an in-memory queue and schedules submitted tasks based on thread
		 * availability.
		 */
		ExecutorService executor = Executors.newFixedThreadPool(10);
		executor.submit(new Task());
		// or
		executor.submit(() -> {
			new Task();
		});

		System.out.println("\n  ScheduledExecutorService");
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

		Future<String> future = executorService.schedule(() -> {
			System.out.println("mula");
			return "Hello world";
		}, 1, TimeUnit.SECONDS);
		System.out.println(future.get());

		ScheduledFuture<?> scheduledFuture = executorService.schedule(() -> {
			System.out.println("ola");
		}, 1, TimeUnit.SECONDS);
		System.out.println(scheduledFuture.get());

		executorService.shutdown();

	}

	public static void execute() {
		Executor executor = new Invoker();
		executor.execute(() -> {
			// task to be performed
			System.out.println("customer ExecutorService done");
		});
	}

}

/**
 * Custom ExecutorService
 *
 */
class Invoker implements Executor {
	@Override
	public void execute(Runnable r) {
		r.run();
	}
}

class Task implements Runnable {
	@Override
	public void run() {
		// task details
		System.out.println("ExecutorService instance and assign this task");
	}
}
