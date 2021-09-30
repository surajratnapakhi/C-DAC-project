package com.gym.management.gymManagement.model;

import lombok.Builder;

@Builder
public class ClientMaster {
	
	 private long id;
	 //Please note that by default user name is first_name
	 private String first_name;
	 private String last_name;
	 private String password;
	 private int age;
	
	public ClientMaster(long id, String first_name, String last_name, String password, int age) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.password = password;
		this.age = age;
	}
	public ClientMaster() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "ClientMaster [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", password="
				+ password + ", age=" + age + "]";
	}
	
	 
}
