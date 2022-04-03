package com.autoparts.model;

public class User {
	    private int id;
	    private String fullname;
	    private String email;
	    private String password;
	    private String designation;
	 
	    public User() {
			// TODO Auto-generated constructor stub
		}

		public User(int id, String fullname, String email, String password, String designation) {
			super();
			this.id = id;
			this.fullname = fullname;
			this.email = email;
			this.password = password;
			this.designation = designation;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getFullname() {
			return fullname;
		}

		public void setFullname(String fullname) {
			this.fullname = fullname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getDesignation() {
			return designation;
		}

		public void setDesignation(String designation) {
			this.designation = designation;
		}
}
