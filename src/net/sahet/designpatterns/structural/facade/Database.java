package net.sahet.designpatterns.structural.facade;

import java.sql.ResultSet;

public abstract class Database {

	public Database(String driver) {
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
