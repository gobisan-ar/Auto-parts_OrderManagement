package com.autoparts.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AutoPartsDBConnection {
	private String jdbcURL = "jdbc:sqlserver://localhost\\DESKTOP-EH7IN5D:1433;databaseName=FoztiAP";
	// jdbc:mysql://localhost:3306/autoparts?useSSL=false
	private String jdbcUsername = "sa"; //"root"
	private String jdbcPassword = "microsql123"; //"gobisql123"

	// get database connection
	protected Connection getConnection() {
		Connection connection = null;

		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // com.mysql.jdbc.Driver
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return connection;
	}
}
