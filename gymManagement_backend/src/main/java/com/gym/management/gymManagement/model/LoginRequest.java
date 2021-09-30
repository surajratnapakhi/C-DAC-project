package com.gym.management.gymManagement.model;

public class LoginRequest {

	 private String userName;
	 private String password;
	public LoginRequest(long id, String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "LoginRequest [userName=" + userName + ", password=" + password + "]";
	}

	public LoginRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
}
