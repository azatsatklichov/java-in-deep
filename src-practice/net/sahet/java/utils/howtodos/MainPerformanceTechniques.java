package net.sahet.java.utils.howtodos;

//https://jenkov.com/tutorials/java-performance/index.html
public class MainPerformanceTechniques {
	/**
	 * There are many different performance optimization tricks within Java
	 * development, but they all tend to fall into one of the following categories:
	 * 
	 * Reduce the work (operations) required to perform the task.
	 * 
	 * Align code with the hardware (CPU, RAM, SSD etc.) (AKA mechanical sympathy)
	 * 
	 * Parallelize tasks when possible, as much as possible, and when it makes
	 * sense.
	 * 
	 * <pre>
	 * Aspects Impacting Performance
	There are a few recurring aspects of any system that impacts its performance. These aspects are:
	
	Memory Management
	Data Structures
	Algorithms
	Concurrency
	Network Communication
	Scalability
	
	
	Reusable Java Performance Principles
	
	Core Java Perfomance Principles
	The most common core principles of Java performance tuning which the tips in this tutorial are based on, are:
	
	Memory is faster than disk - much faster - and memory is cheap.
	All storage (memory / disk) works fastest when read from or written to sequentially. Arbitrary access is slower.
	Object allocation and garbage collection is slow.
	Data formats and data structures make a big difference in speed.
	Asynchronous IO scales better than synchronous IO.
	Singlethreaded performance is a prerequisite for multithreaded performance.
	Shared memory (or disk) concurrency is bad because it usually leads to lots of contention when the system gets busy.
	
	Java Performance Credits
	The principles and techniques presented in this Java performance tutorial are not all mine. Far from, actually. These tutorials present work by Java performance master minds who have learned and polished these techniques in real life high performance systems. Here are some of the Java performance master minds who's work have inspired or contributed to this Java performance tutorial (the order is random):
	
	Aleksey Shipilëv - https://shipilev.net/
	Martin Thompson - https://mechanical-sympathy.blogspot.com/?fireglass_rsn=true#fireglass_params&tabid=a33761e4ef856dc5&start_with_session_counter=2&application_server_address=isolation1-eu-central-1.wss.prod.fire.glass
	Azul Systems - https://www.azul.com/
	Peter Lawrey - http://vanillajava.blogspot.de/
	Rick Hightower
	The Psy-Lob-Saw Blog
	The High Scalability Blog
	... more coming ...
	 * </pre>
	 */
	public static void main(String[] args) {
		//https://jenkov.com/tutorials/java-performance/resizable-array.html

	}

}
