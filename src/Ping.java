package net.sahet.utils;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ping {
/*	public static void main2(String[] args) {
		byte[] a = { 192, 168, 6, 104 };
		boolean reachable;
		reachable = InetAddress.getByAddress(a).isReachable(4000);
		if (reachable)
			System.out.println("Pinged");
		else
			System.out.println("Not Pinged");
	}*/

	public static void main(String[] args) throws UnknownHostException, IOException {
		boolean reachable; 
		reachable = InetAddress.getByName("192.168.6.104").isReachable(4000);
		if (reachable)
			System.out.println("Pinged");
		else
			System.out.println("Not Pinged");
		  
		reachable = InetAddress.getByName("http://www.sahet.net").isReachable(4000);
		if (reachable)
			System.out.println("Pinged");
		else
			System.out.println("Not Pinged");
	}
}
