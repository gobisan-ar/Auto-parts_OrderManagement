package com.autoparts.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.autoparts.model.CustomerOrder;
import com.autoparts.model.PendingOrder;
import com.autoparts.model.ShippedOrder;


public class CustomerOrderService {
	private String jdbcURL = "jdbc:sqlserver://localhost\\DESKTOP-EH7IN5D:1433;databaseName=FoztiAP";
	// jdbc:mysql://localhost:3306/autoparts?useSSL=false
	private String jdbcUsername = "sa"; //"root"
	private String jdbcPassword = "microsql123"; //"gobisql123"

	// Query
	private static final String INSERT_CUSTOMERORDER_SQL ="INSERT INTO customer_order" + "(customerid, deliveryAddress) VALUES " + "(?, ?);";
	private static final String SELECT_CUSTOMERORDER_SQL = "SELECT orderid,customerid, deliveryAddress, orderStatus, statusReason, shipperID FROM customer_order WHERE orderid = ?;";
	private static final String SELECT_ALL_CUSTOMERORDERS_SQL = "SELECT * FROM customer_order ORDER BY orderid DESC;";
	private static final String DELETE_CUSTOMERORDER_SQL = "DELETE FROM customer_order WHERE orderid = ?;";
	private static final String UPDATE_CUSTOMERORDER_SQl = "UPDATE customer_order SET orderStatus = ?, statusReason = ?, shipperID = ? WHERE orderid = ?;";
	private static final String CHANGE_CUSTOMERORDER_STATUS_SQL = "UPDATE customer_order SET orderStatus = ? WHERE orderid = ?;";
	private static final String SELECT_ALL_ORDERS_STATUS_SQL = "SELECT * FROM customer_order WHERE orderStatus = ? ORDER BY orderid DESC;";
	private static final String SHIP_CUSTOMERORDER_SQL = "UPDATE customer_order SET shipperID = ?, orderStatus = ? WHERE orderid = ?;";
	private static final String HOLD_CUSTOMERORDER_SQL = "UPDATE customer_order SET pendingReason = ?, orderStatus = ? WHERE orderid = ?;";
	
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

	// select all Customer Orders
	public List<CustomerOrder> selectallCustomerOrders() {
		List<CustomerOrder> corders = new ArrayList<>();
		// establish database connection
		try (Connection connection = getConnection();
				// create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMERORDERS_SQL);){
			// execute the query
			ResultSet rs = preparedStatement.executeQuery();

			// process the ResultSet object
			while(rs.next()) {
				int oid = rs.getInt("orderid");
				int cid = rs.getInt("customerid");
				String status = rs.getString("orderStatus");
				
				corders.add(new CustomerOrder(oid, cid, status));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return corders;
	}	
	
	// list shipped order
	public List<ShippedOrder> selectallShippedOrders() {
		List<ShippedOrder> sorders = new ArrayList<>();
		// establish database connection
		try (Connection connection = getConnection();
				// create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERS_STATUS_SQL);){
			preparedStatement.setString(1, "shipped");
			// execute the query
			ResultSet rs = preparedStatement.executeQuery();

			// process the ResultSet object
			while(rs.next()) {
				int oid = rs.getInt("orderid");
				int cid = rs.getInt("customerid");
				double pay = rs.getDouble("payment");
				String delivery = rs.getString("deliveryAddress");
				String ostatus = rs.getString("orderStatus");
				int sid = rs.getInt("shipperid");
				String sdate = rs.getString("shippedDate");
				
				sorders.add(new ShippedOrder(oid, cid, ostatus, delivery, pay, sdate, sid));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sorders;
	}	
	
	// list pending orders
	public List<PendingOrder> selectallPendingOrders() {
		List<PendingOrder> porders = new ArrayList<>();
		// establish database connection
		try (Connection connection = getConnection();
				// create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERS_STATUS_SQL);){
			preparedStatement.setString(1, "Pending");
			// execute the query
			ResultSet rs = preparedStatement.executeQuery();

			// process the ResultSet object
			while(rs.next()) {
				int oid = rs.getInt("orderid");
				int cid = rs.getInt("customerid");
				String status = rs.getString("orderStatus");
				String reason = rs.getString("pendingReason");
				
				porders.add(new PendingOrder(oid, cid, status, reason));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return porders;
	}	
	
	// list new orders
	public List<CustomerOrder> selectallNewOrders() {
		List<CustomerOrder> norders = new ArrayList<>();
		// establish database connection
		try (Connection connection = getConnection();
				// create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ORDERS_STATUS_SQL);){
			preparedStatement.setString(1, "new");
			// execute the query
			ResultSet rs = preparedStatement.executeQuery();

			// process the ResultSet object
			while(rs.next()) {
				int oid = rs.getInt("orderid");
				int cid = rs.getInt("customerid");
				String ostatus = rs.getString("orderStatus");
				String pstatus;
				String sstatus;
				
				if(rs.getInt("payStatus") == 0) 
					 pstatus = "Incomplete";
				else
					 pstatus = "Paid";
				
				if(rs.getInt("stockStatus") == 0) 
					 sstatus = "Un-available";
				else
					 sstatus = "Available";
				
				norders.add(new CustomerOrder(oid, cid, ostatus, pstatus, sstatus));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return norders;
	}
	
	// delete customer order
		public boolean deleteCustomerOrder(int oid) throws SQLException{
			boolean rowDeleted;
			// establish database connection
			try(Connection connection = getConnection();
					// create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMERORDER_SQL);){
				preparedStatement.setInt(1, oid);
				// execute the query
				rowDeleted = preparedStatement.executeUpdate() > 0;
			}
			return rowDeleted;
		}
		
		// accept customer order
				public boolean acceptCustomerOrder(int oid) throws SQLException{
					boolean rowUpdated;
					// establish database connection
					try(Connection connection = getConnection();
							// create a statement using connection object
							PreparedStatement preparedStatement = connection.prepareStatement(CHANGE_CUSTOMERORDER_STATUS_SQL);){
						preparedStatement.setString(1, "new");
						preparedStatement.setInt(2, oid);
						// execute the query
						rowUpdated = preparedStatement.executeUpdate() > 0;
					}
					return rowUpdated;
				}
				
				// ship customer order
				public boolean shipCustomerOrder(int oid, String sid) throws SQLException{
					boolean rowUpdated;
					// establish database connection
					try(Connection connection = getConnection();
							// create a statement using connection object
							PreparedStatement preparedStatement = connection.prepareStatement(SHIP_CUSTOMERORDER_SQL);){
						preparedStatement.setString(1, sid);
						preparedStatement.setString(2, "shipped");
						preparedStatement.setInt(3, oid);
						// execute the query
						rowUpdated = preparedStatement.executeUpdate() > 0;
					}
					
					return rowUpdated;
				}
				
				// hold customer order
				public boolean holdCustomerOrder(int oid, String reason) throws SQLException{
					boolean rowUpdated;
					// establish database connection
					try(Connection connection = getConnection();
							// create a statement using connection object
							PreparedStatement preparedStatement = connection.prepareStatement(HOLD_CUSTOMERORDER_SQL);){
						preparedStatement.setString(1, reason);
						preparedStatement.setString(2, "pending");
						preparedStatement.setInt(3, oid);
						// execute the query
						rowUpdated = preparedStatement.executeUpdate() > 0;
					}
					return rowUpdated;
				}
		
		
}
	
	