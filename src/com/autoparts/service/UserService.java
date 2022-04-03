package com.autoparts.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.autoparts.model.User;

public class UserService {
	private String jdbcURL = "";
	private String jdbcUsername = "";
	private String jdbcPassword = "";

	// Query
	private static final String SELECT_USER_SQL ="SELECT * FROM users WHERE email = ? AND password = ?";


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

	//  select login shippings
	public User checkLogin(String email, String password) {
		// user object
		User user = new User();
		// establish database connection
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_SQL);){
			preparedStatement.setString(1, "email");
			preparedStatement.setString(2, "password");
			// execute the query
			ResultSet rs = preparedStatement.executeQuery();

			// process the ResultSet object
	
			while (rs.next()) {
				user.setFullname(rs.getString("fullname"));
				user.setDesignation(rs.getString("designation"));
			}

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}

