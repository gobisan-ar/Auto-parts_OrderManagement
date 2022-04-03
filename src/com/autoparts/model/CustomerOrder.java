package com.autoparts.model;

public class CustomerOrder {
	private int orderID;
	private int customerID;
	private String orderStatus;
	private String paymentStatus;
	private String stockStatus;

	
	public CustomerOrder() {
		// TODO Auto-generated constructor stub
	}


	public CustomerOrder(int orderID, int customerID, String orderStatus, String paymentStatus, String stockStatus) {
		this.orderID = orderID;
		this.customerID = customerID;
		this.orderStatus = orderStatus;
		this.paymentStatus = paymentStatus;
		this.stockStatus = stockStatus;
	}


	public CustomerOrder(int orderID, int customerID, String orderStatus) {
		this.orderID = orderID;
		this.customerID = customerID;
		this.orderStatus = orderStatus;
	}


	public int getOrderID() {
		return orderID;
	}


	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}


	public int getCustomerID() {
		return customerID;
	}


	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getOrderStatus() {
		return orderStatus;
	}


	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}


	public String getPaymentStatus() {
		return paymentStatus;
	}


	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}


	public String getStockStatus() {
		return stockStatus;
	}


	public void setStockStatus(String stockStatus) {
		this.stockStatus = stockStatus;
	}
}

	