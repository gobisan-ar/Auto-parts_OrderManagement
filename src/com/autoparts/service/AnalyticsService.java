package com.autoparts.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.autoparts.model.CustomerOrder;
import com.autoparts.model.Analytics;


public class AnalyticsService {
	private String jdbcURL = "jdbc:sqlserver://localhost\\DESKTOP-EH7IN5D:1433;databaseName=FoztiAP";
	// jdbc:mysql://localhost:3306/autoparts?useSSL=false
	private String jdbcUsername = "sa"; //"root"
	private String jdbcPassword = "microsql123"; //"gobisql123"

	// Query
	private static final String TOTAL_SHIPPINGS_SQL ="SELECT COUNT(orderid) AS totShip FROM customer_order WHERE orderStatus = ?";
	private static final String TOTAL_ORDERS_SQL ="SELECT COUNT(orderid) FROM customer_order";
	private static final String TOTAL_SALES_SQL ="SELECT SUM(payment) AS totSale FROM customer_order";
	private static final String MAX_ZONE_BUDGET_SQL ="SELECT name,  MAX(budget) AS maxBudget FROM shipping_zone GROUP BY name";
	private static final String SELECT_NEW_ORDERS_SQL ="SELECT TOP 5 * FROM customer_order WHERE orderStatus = ? ORDER BY orderid DESC";
	private static final String SHIPPING_PERCENTAGE ="{? = call shippingPercentage()}";

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

	// get total shippings
	public Analytics showAnalytics() {
		// list new orders
		List<CustomerOrder> norders = new ArrayList<>();
		Analytics rep = new Analytics();

		// establish database connection
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement1 = connection.prepareStatement(SELECT_NEW_ORDERS_SQL);){
			preparedStatement1.setString(1, "new");
			// execute the query
			ResultSet rs1 = preparedStatement1.executeQuery();

			// process the ResultSet object
			while(rs1.next()) {
				int oid = rs1.getInt("orderid");
				int cid = rs1.getInt("customerid");
				String ostatus = rs1.getString("orderStatus");
				String pstatus;
				String sstatus;

				if(rs1.getInt("payStatus") == 0) 
					pstatus = "Incomplete";
				else
					pstatus = "Paid";

				if(rs1.getInt("stockStatus") == 0) 
					sstatus = "Un-available";
				else
					sstatus = "Available";

				norders.add(new CustomerOrder(oid, cid, ostatus, pstatus, sstatus));
				rep.setNewOrder(norders);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		try (Connection connection = getConnection();
				// create a statement using connection object
				PreparedStatement preparedStatement2 = connection.prepareStatement(TOTAL_SHIPPINGS_SQL);){
			preparedStatement2.setString(1, "shipped");
			// execute the query
			ResultSet rs2 = preparedStatement2.executeQuery();

			// process the ResultSet object
			while(rs2.next()) {
				int totShip = rs2.getInt("totShip");
				rep.setShip(totShip);;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// total sales
		try (Connection connection = getConnection();
				// create a statement using connection object
				PreparedStatement preparedStatement3 = connection.prepareStatement(TOTAL_SALES_SQL);){
			// execute the query
			ResultSet rs3 = preparedStatement3.executeQuery();

			// process the ResultSet object
			while(rs3.next()) {
				int totSale = rs3.getInt("totSale");
				rep.setSale(totSale);;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// total zone budget
				try (Connection connection = getConnection();
						// create a statement using connection object
						PreparedStatement preparedStatement4 = connection.prepareStatement(MAX_ZONE_BUDGET_SQL);){
					// execute the query
					ResultSet rs4 = preparedStatement4.executeQuery();

					// process the ResultSet object
					while(rs4.next()) {
						String zone = rs4.getString("name");
						int maxBudget = rs4.getInt("maxBudget");
						rep.setBudget(maxBudget);;
						rep.setZone(zone);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				// shipping percentage
				try (Connection connection = getConnection();
						// create a statement using connection object
						CallableStatement callablestatement = connection.prepareCall(SHIPPING_PERCENTAGE);){
					callablestatement.registerOutParameter(1, java.sql.Types.REAL);
					
					// execute the query
					callablestatement.execute();

					//get return value
						double pct = callablestatement.getDouble(1);
						System.out.println(pct);
						rep.setShipPct(pct);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
		return rep;
	}
}

