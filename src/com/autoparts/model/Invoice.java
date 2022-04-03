package com.autoparts.model;

import com.autoparts.util.CalculateTotal;
import com.autoparts.util.GenerateInvoiceID;


public class Invoice implements  CalculateTotal, GenerateInvoiceID{
	private int invoiceID;
	private int orderID;
	private String date;
	private double total;
	private double payment;
	private final double tax = 250;
	private final double discount = 100;
	
	
	public Invoice() {
		// TODO Auto-generated constructor stub
	}

	public Invoice(int invoiceID, int orderID, String date, double total, double payment) {
		super();
		this.invoiceID = invoiceID;
		this.orderID = orderID;
		this.date = date;
		this.total = total;
		this.payment = payment;
	}
	
	public Invoice(int orderID, double payment, String date) {
		this.invoiceID = generateInvoiceID();
		this.orderID = orderID;
		this.payment = payment;
		this.date = date;
		this.total = calcTotal();
	}
	
	public int getInvoiceID() {
		return invoiceID;
	}


	public void setInvoiceID(int invoiceID) {
		this.invoiceID = invoiceID;
	}


	public int getOrderID() {
		return orderID;
	}


	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


	public double getPayment() {
		return payment;
	}


	public void setPayment(double payment) {
		this.payment = payment;
	}


	public double getTax() {
		return tax;
	}

	public double getDiscount() {
		return discount;
	}
	
	public double calcTotal() {
		double sum;

		sum = this.payment + this.tax - this.discount;
		
		return sum;
	}
	
	public int generateInvoiceID() {
		int upperBound = 500000000;
	    int lowerBound = 495465400;

	    // upperBound 20 will also be included
	    int range = (upperBound - lowerBound) + 1;


	      // generate random number
	      // (int) convert double value to int
	      // Math.round() generate value between 0.0 and 1.0
	      int random = (int)(Math.random() * range) + lowerBound;
	      
	      return random;
	}
}
