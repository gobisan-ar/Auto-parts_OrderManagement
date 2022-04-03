package com.autoparts.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.autoparts.model.ShippingZone;

import java.util.ArrayList;


/**
 * This DAO class provides
 * CRUD database operations
 * for the table shiping_zone 
 * in the database AutoParts
 */
public class ShippingZoneService {
	private String jdbcURL = "jdbc:sqlserver://localhost\\DESKTOP-EH7IN5D:1433;databaseName=FoztiAP";
	// jdbc:mysql://localhost:3306/autoparts?useSSL=false
	private String jdbcUsername = "sa"; //"root"
	private String jdbcPassword = "microsql123"; //"gobisql123"

	// Query
	private static final String INSERT_SHIPPINGZONE_SQL ="INSERT INTO shipping_zone" + "(name, area, budget) VALUES " + "(?, ?, ?);";
	private static final String SELECT_SHIPPINGZONE_SQL = "SELECT zoneid, name, area, budget FROM shipping_zone WHERE zoneid = ?;";
	private static final String SELECT_ALL_SHIPPINGZONES_SQL = "SELECT * FROM shipping_zone;";
	private static final String DELETE_SHIPPINGZONE_SQL = "DELETE FROM shipping_zone WHERE zoneid = ?;";
	private static final String UPDATE_SHIPPINGZONE_SQl = "UPDATE shipping_zone SET name = ?, area = ?, budget = ? WHERE zoneid = ?;";

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

	// insert shipping zone
	public void insertShippingZone(ShippingZone szone) throws SQLException {
		// establish database connection
		try(Connection connection = getConnection();
				// create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SHIPPINGZONE_SQL)){
			preparedStatement.setString(1, szone.getName());
			preparedStatement.setDouble(2, szone.getArea());
			preparedStatement.setDouble(3, szone.getBudget());
			// execute the query
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	// update shipping zone
	public boolean updateShippingZone(ShippingZone szone) throws SQLException {
		boolean rowUpdated;
		// establish database connection
		try(Connection connection = getConnection();
				// create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_SHIPPINGZONE_SQl);){
			preparedStatement.setString(1, szone.getName());
			preparedStatement.setDouble(2, szone.getArea());
			preparedStatement.setDouble(3, szone.getBudget());
			preparedStatement.setInt(4, szone.getZoneID());
			// execute the query
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	// select shipping zone
	public ShippingZone selectShippingZone(int zid) {
		ShippingZone szone = null;
		// establish database connection
		try (Connection connection = getConnection()){
			// create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SHIPPINGZONE_SQL);{
				preparedStatement.setInt(1, zid);
				// execute the query
				ResultSet rs = preparedStatement.executeQuery();

				// process the ResultSet object
					String name = rs.getString("name");
					double area = Double.parseDouble(rs.getString("area"));
					double budget = Double.parseDouble(rs.getString("area"));
					szone = new ShippingZone(zid, name, area, budget);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return szone;
	}

	// select all shipping zones
	public List<ShippingZone> selectallShippingZones() {
		List<ShippingZone> szones = new ArrayList<>();
		// establish database connection
		try (Connection connection = getConnection();
				// create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SHIPPINGZONES_SQL);){
			// execute the query
			ResultSet rs = preparedStatement.executeQuery();

			// process the ResultSet object
			while(rs.next()) {
				int zid = rs.getInt("zoneid");
				String name = rs.getString("name");
				Double area = Double.parseDouble(rs.getString("area"));
				Double budget = Double.parseDouble(rs.getString("budget"));
				szones.add(new ShippingZone(zid, name, area, budget));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("Zones " + szones);
		return szones;
	}

	// delete shipping zone
	public boolean deleteShippingZone(int zid) throws SQLException{
		boolean rowDeleted;
		// establish database connection
		try(Connection connection = getConnection();
				// create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_SHIPPINGZONE_SQL);){
			preparedStatement.setInt(1, zid);
			// execute the query
			rowDeleted = preparedStatement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
}
