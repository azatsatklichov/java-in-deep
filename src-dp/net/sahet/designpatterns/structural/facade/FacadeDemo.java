package net.sahet.designpatterns.structural.facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.ResultSet;

public class FacadeDemo {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("\n	Facade design pattern example ");

		Amplifier amp = new Amplifier("Top-O-Line Amplifier");
		Tuner tuner = new Tuner("Top-O-Line AM/FM Tuner", amp);
		DvdPlayer dvd = new DvdPlayer("Top-O-Line DVD Player", amp);
		CdPlayer cd = new CdPlayer("Top-O-Line CD Player", amp);
		Projector projector = new Projector("Top-O-Line Projector", dvd);
		TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
		Screen screen = new Screen("Theater Screen");
		PopcornPopper popper = new PopcornPopper("Popcorn Popper");
		System.out.println(" \n *** facade*** \n");

		HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, tuner, dvd, cd, projector, screen, lights, popper);

		homeTheater.watchMovie("Raiders of the Lost Ark");
		homeTheater.endMovie();

		System.out.println("\n	Facade Java build-in classes ");
		/**
		 * java.net.URL
		 * 
		 * javax.faces.context.FacesContext
		 * 
		 */
		Thread.currentThread().sleep(2000);
		URL url = new URL("http://sahet.net/htm/java.html");
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		int countLine = 0;
		String line;
		while ((line = br.readLine()) != null && countLine < 15) {
			System.out.println(line);
			countLine++;
		}
	}
}

//another example
abstract class DatabaseFacade {

	public DatabaseFacade(String driver) {
	};

	public void Open(String url, String cat) {
	};

	public String[] getTableNames() {
		return null;
	};

	public String[] getColumnNames(String table) {
		return null;
	};

	public String getColumnValue(String table, String columnName) {
		return null;
	};

	public String getNextValue(String columnName) {
		return null;
	};

	public ResultSet Execute(String sql) {
		return null;
	};

}