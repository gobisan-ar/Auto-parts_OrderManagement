package com.autoparts.model;

public class DeliveryStaff {
	private int staffID;
	private String firstname;
	private String lastname;
	private String email;
	private String mobile;
	private String nic;
	private  String status;
		
	public DeliveryStaff() {
		// Default constructor
	}

	public DeliveryStaff(int staffID, String firstname, String lastname, String email, String mobile, String nic, String status) {
		this.staffID = staffID;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobile = mobile;
		this.nic = nic;
		this.status = status;
	}
	
	public DeliveryStaff(String firstname, String lastname, String email, String mobile, String nic, String status) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobile = mobile;
		this.nic = nic;
		this.status = status;
	}
	
	public DeliveryStaff(String firstname, String lastname, String email, String mobile, String nic) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.mobile = mobile;
		this.nic = nic;
	}

	public DeliveryStaff(DeliveryStaff dstaff) {
		this.staffID = dstaff.staffID;
		this.firstname = dstaff.firstname;
		this.lastname = dstaff.lastname;
		this.email = dstaff.email;
		this.mobile = dstaff.mobile;
		this.nic = dstaff.nic;
		this.status = dstaff.status;
	}

	public int getStaffID() {
		return staffID;
	}

	public void setStaffID(int staffID) {
		this.staffID = staffID;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
}

