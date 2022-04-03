package com.autoparts.model;
import java.util.List;

public class Analytics {
	private int ship;
	private double sale;
	private double budget;
	private String zone;
	private double shipPct;
	private List<CustomerOrder> newOrder;
	
	public Analytics() {
		// TODO Auto-generated constructor stub
	}

	public Analytics(int ship, double sale, double budget, String zone, double shipPct, List<CustomerOrder> newOrder) {
		super();
		this.ship = ship;
		this.sale = sale;
		this.budget = budget;
		this.zone = zone;
		this.shipPct = shipPct;
		this.newOrder = newOrder;
	}

	public int getShip() {
		return ship;
	}

	public void setShip(int ship) {
		this.ship = ship;
	}

	public double getSale() {
		return sale;
	}

	public void setSale(double sale) {
		this.sale = sale;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}
	
	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}
	
	public double getShipPct() {
		return shipPct;
	}

	public void setShipPct(double shipPct) {
		this.shipPct = shipPct;
	}

	public List<CustomerOrder> getNewOrder() {
		return newOrder;
	}

	public void setNewOrder(List<CustomerOrder> newOrder) {
		this.newOrder = newOrder;
	}	
}
