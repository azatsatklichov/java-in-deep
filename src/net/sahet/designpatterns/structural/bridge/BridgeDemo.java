package net.sahet.designpatterns.structural.bridge;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BridgeDemo {
	public static void main(String[] args) throws SQLException {
		System.out.println("\n	Bridge design pattern example ");

		Formatter bannerFormatter = new BannerFormatter();
		Formatter htmlFormatter = new HtmlFormatter();
		
		Movie movie = getMovie();
		Banner movieBanner = new MovieBanner(movie);
		String info = movieBanner.print(bannerFormatter);
		System.out.println(info);

		info = movieBanner.print(htmlFormatter);
		System.out.println(info);

		System.out.println("\n	Bridge Java build-in classes ");
		/**
		 * Bridge
		 * 
		 * JDBC
		 * 
		 */
		//jdbcBridge();
	}

	private static Movie getMovie() {
		Movie movie = new Movie();
		movie.setClassification("Komediýa");
		movie.setTitle("Yuwas Gelin");
		movie.setRuntime("2:15");
		movie.setYear("1967");
		return movie;
	}

	private static void jdbcBridge() throws SQLException {
		DriverManager.registerDriver(null); // registerDriver(new org.apache.derby.jdbc.EmbeddedDriver())
		String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";
		Connection conn = DriverManager.getConnection(dbUrl);
		Statement sta = (Statement) conn.createStatement();
	}
}
