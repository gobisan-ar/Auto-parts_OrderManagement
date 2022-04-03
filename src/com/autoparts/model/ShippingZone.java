package com.autoparts.model;

public class ShippingZone {
	private int zoneID;
	private String name;
	private double area;
	private double budget;
		
	public ShippingZone() {
		// Default constructor
	}

	public ShippingZone(int zoneID, String name, double area, double budget) {
		this.zoneID = zoneID;
		this.name = name;
		this.area = area;
		this.budget = budget;
	}

	public ShippingZone(String name, double area, double budget) {
		this.name = name;
		this.area = area;
		this.budget = budget;
	}
	
	public ShippingZone(ShippingZone szone) {
		this.zoneID = szone.zoneID;
		this.name = szone.name;
		this.area = szone.area;
		this.budget = szone.budget;
	}

	public int getZoneID() {
		return zoneID;
	}

	public void setZoneID(int zoneID) {
		this.zoneID = zoneID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}
}
