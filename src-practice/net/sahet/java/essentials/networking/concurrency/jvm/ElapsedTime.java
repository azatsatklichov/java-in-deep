package net.sahet.java.essentials.networking.concurrency.jvm;

import java.io.File;

public class ElapsedTime {
	public static void main(String[] args) {
		File file = new File("C:");
		System.out.println("C:");
		System.out.println("Total Space:  " + file.getTotalSpace());
		System.out.println("Free Space:   " + file.getFreeSpace());
		System.out.println("Usable Space: " + file.getUsableSpace());

		file = new File("C:\\Windows");
		System.out.println("\nC:\\windows (exist)");
		System.out.println("Total Space:  " + file.getTotalSpace());
		System.out.println("Free Space:   " + file.getFreeSpace());
		System.out.println("Usable Space: " + file.getUsableSpace());

		file = new File("D:\\windows");
		System.out.println("\nD:\\windows (not exist)");
		System.out.println("Total Space:  " + file.getTotalSpace());
		System.out.println("Free Space:   " + file.getFreeSpace());
		System.out.println("Usable Space: " + file.getUsableSpace());
	}

}
