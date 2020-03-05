package net.sahet.designpatterns.structural.bridge;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BridgeDemo {
	public static void main(String[] args) throws SQLException {

		System.out.println("\n	Bridge Java build-in classes ");
		/**
		 * Bridge
		 * 
		 * JDBC
		 * 
		 */
		DriverManager.registerDriver(null); // registerDriver(new org.apache.derby.jdbc.EmbeddedDriver())
		String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";
		Connection conn = DriverManager.getConnection(dbUrl);
		Statement sta = (Statement) conn.createStatement();
	}
}
