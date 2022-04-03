package com.autoparts.model;

public class ShippedOrder extends CustomerOrder {
	private String deliveryAddress;
	private double payment;
	private String shippedDate;
	private int shipperID;
	
	public ShippedOrder() {
		// TODO Auto-generated constructor stub
	}
	
	public ShippedOrder(int orderID, int customerID, String orderStatus, String paymentStatus, String stockStatus, String deliveryAddress,  double payment, String shippedDate, int shipperID) {
		super(orderID, customerID, orderStatus, paymentStatus, stockStatus);
		this.deliveryAddress = deliveryAddress;
		this.payment = payment;
		this.shippedDate = shippedDate;
		this.shipperID = shipperID;
	}

	public ShippedOrder(String deliveryAddress, double payment, String shippedDate, int shipperID) {
		super();
		this.deliveryAddress = deliveryAddress;
		this.payment = payment;
		this.shippedDate = shippedDate;
		this.shipperID = shipperID;
	}

	public ShippedOrder(int orderID, int customerID, String orderStatus, String paymentStatus, String stockStatus) {
		super(orderID, customerID, orderStatus, paymentStatus, stockStatus);
		// TODO Auto-generated constructor stub
	}
	

	public ShippedOrder(int orderID, int customerID, String orderStatus, String deliveryAddress, double payment, String shippedDate, int shipperID) {
		super(orderID, customerID, orderStatus);
		this.deliveryAddress = deliveryAddress;
		this.payment = payment;
		this.shippedDate = shippedDate;
		this.shipperID = shipperID;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getShippedDate() {
		return shippedDate;
	}
	

	public double getPayment() {
		return payment;
	}

	public void setPayment(double payment) {
		this.payment = payment;
	}

	public void setShippedDate(String shippedDate) {
		this.shippedDate = shippedDate;
	}

	public int getShipperID() {
		return shipperID;
	}

	public void setShipperID(int shipperID) {
		this.shipperID = shipperID;
	}
	
	
	
	
}
