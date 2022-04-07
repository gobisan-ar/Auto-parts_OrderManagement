package com.autoparts.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AutoPartsDBConnection {
	private String jdbcURL = "jdbc:sqlserver://localhost"; // add server name and database name 
	private String jdbcUsername = ""; 
	private String jdbcPassword = "";

	// get database connection
	protected Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return connection;
	}
}
