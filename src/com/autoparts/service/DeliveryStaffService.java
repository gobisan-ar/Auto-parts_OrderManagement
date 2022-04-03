package com.autoparts.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.autoparts.model.DeliveryStaff;

import java.util.ArrayList;


/**
 * This DAO class provides
 * CRUD database operations
 * for the table shiping_zone 
 * in the database AutoParts
 */
public class DeliveryStaffService {
	private String jdbcURL = "jdbc:sqlserver://localhost\\DESKTOP-EH7IN5D:1433;databaseName=FoztiAP";
	// jdbc:mysql://localhost:3306/autoparts?useSSL=false
	private String jdbcUsername = "sa"; //"root"
	private String jdbcPassword = "microsql123"; //"gobisql123"

	// Query
	private static final String INSERT_DELIVERYSTAFF_SQL ="INSERT INTO delivery_staff" + "(firstname, lastname, email, mobile, nic) VALUES " + "(?, ?, ?, ?, ?);";
	private static final String SELECT_DELIVERYSTAFF_SQL = "SELECT staffid, firstname, lastname, email, mobile, nic, status FROM delivery_staff WHERE staffid = ?;";
	private static final String SELECT_ALL_DELIVERYSTAFFS_SQL = "SELECT * FROM delivery_staff ORDER BY staffid DESC;";
	private static final String DELETE_DELIVERYSTAFF_SQL = "DELETE FROM delivery_staff WHERE staffid = ?;";
	private static final String UPDATE_DELIVERYSTAFF_SQl = "UPDATE delivery_staff SET firstname = ?, lastname = ?, email = ?, mobile = ?, nic = ?, status = ? WHERE staffid = ?;";

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

	// insert Delivery Staff
	public void insertDeliveryStaff(DeliveryStaff dstaff) throws SQLException {
		// establish database connection
		try(Connection connection = getConnection();
				// create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DELIVERYSTAFF_SQL)){
			preparedStatement.setString(1, dstaff.getFirstname());
			preparedStatement.setString(2, dstaff.getLastname());
			preparedStatement.setString(3, dstaff.getEmail());
			preparedStatement.setString(4, dstaff.getMobile());
			preparedStatement.setString(5, dstaff.getNic());
			// execute the query
			preparedStatement.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// update Delivery Staff
	public boolean updateDeliveryStaff(DeliveryStaff dstaff) throws SQLException {
		boolean rowUpdated;
		// establish database connection
		try(Connection connection = getConnection();
				// create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_DELIVERYSTAFF_SQl);){
			preparedStatement.setString(1, dstaff.getFirstname());
			preparedStatement.setString(2, dstaff.getLastname());
			preparedStatement.setString(3, dstaff.getEmail());
			preparedStatement.setString(4, dstaff.getMobile());
			preparedStatement.setString(5, dstaff.getNic());
			preparedStatement.setString(6, dstaff.getStatus());
			preparedStatement.setInt(7, dstaff.getStaffID());
			// execute the query
			rowUpdated = preparedStatement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	// select Delivery Staff
	public DeliveryStaff selectDeliveryStaff(int sid) {
		DeliveryStaff dstaff = null;
		// establish database connection
		try (Connection connection = getConnection()){
			// create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DELIVERYSTAFF_SQL);{
				preparedStatement.setInt(1, sid);
				// execute the query
				ResultSet rs = preparedStatement.executeQuery();

				// process the ResultSet object
				String fname = rs.getString("firstname");
				String lname = rs.getString("lastname");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				String nic = rs.getString("nic");
				String status = rs.getString("status");
					
					dstaff = new DeliveryStaff(fname, lname, email, mobile, nic, status);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dstaff;
	}

	// select all Delivery Staffs
	public List<DeliveryStaff> selectallDeliveryStaffs() {
		List<DeliveryStaff> dstaffs = new ArrayList<>();
		// establish database connection
		try (Connection connection = getConnection();
				// create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DELIVERYSTAFFS_SQL);){
			// execute the query
			ResultSet rs = preparedStatement.executeQuery();

			// process the ResultSet object
			while(rs.next()) {
				int sid = rs.getInt("staffid");
				String fname = rs.getString("firstname");
				String lname = rs.getString("lastname");
				String email = rs.getString("email");
				String mobile = rs.getString("mobile");
				String nic = rs.getString("nic");
				String status = rs.getString("status");
				
				dstaffs.add(new DeliveryStaff(sid, fname, lname, email, mobile, nic, status));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dstaffs;
	}

	// delete Delivery Staff
	public boolean deleteDeliveryStaff(int sid) throws SQLException{
		boolean rowDeleted;
		// establish database connection
		try(Connection connection = getConnection();
				// create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(DELETE_DELIVERYSTAFF_SQL);){
			preparedStatement.setInt(1, sid);
			// execute the query
			rowDeleted = preparedStatement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
}
