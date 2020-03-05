package net.sahet.designpatterns.structural.facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class FacadeDemo {
	public static void main(String[] args) throws IOException {

		System.out.println("\n	Facade Java build-in classes ");
		/**
		 * java.net.URL
		 * 
		 * javax.faces.context.FacesContext
		 * 
		 */
		URL url = new URL("http://sahet.net/htm/java.html");
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String line;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}
}
