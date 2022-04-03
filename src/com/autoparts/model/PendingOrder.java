package com.autoparts.model;

public class PendingOrder extends CustomerOrder{
	private String reason;
	
	public PendingOrder() {
		// TODO Auto-generated constructor stub
	}

	public PendingOrder(String reason) {
		super();
		this.reason = reason;
	}

	public PendingOrder(int orderID, int customerID, String orderStatus, String paymentStatus, String stockStatus) {
		super(orderID, customerID, orderStatus, paymentStatus, stockStatus);
		// TODO Auto-generated constructor stub
	}

	public PendingOrder(int orderID, int customerID, String orderStatus) {
		super(orderID, customerID, orderStatus);
		// TODO Auto-generated constructor stub
	}
	
	public PendingOrder(int orderID, int customerID, String orderStatus, String reason) {
		super(orderID, customerID, orderStatus);
		this.reason = reason;
		// TODO Auto-generated constructor stub
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
