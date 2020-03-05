package net.sahet.designpatterns.structural.decorator;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class DecoratorDemo {
	public static void main(String[] args) throws FileNotFoundException, IOException {

		System.out.println("\n	Decorator Java build-in classes ");
		/**
		 * java.io.InputStream
		 * 
		 * java.util.Collections#checkedList
		 * 
		 * UI Components
		 * 
		 */
		String fileName = "C:\\workspace_ext\\java-in-deep\\ps.txt";

		try (InputStream fis = new FileInputStream(fileName);
				InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(isr)) {

			br.lines().forEach(line -> System.out.println(line));

		} 
		
		// or another example
		File f = new File("out.txt");
		f.createNewFile();

		try (OutputStream os = new FileOutputStream(f)) {;
		DataOutputStream dos = new DataOutputStream(os);
		dos.writeChars("bildirsoy");
		};

	}
}
