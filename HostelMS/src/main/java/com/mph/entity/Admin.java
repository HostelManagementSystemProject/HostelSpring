package com.mph.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="ADMIN_HMS")
public class Admin {
	@Id
	private int admin_id;
	private String email_id;
	private String password;
	private long phone_number;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int admin_id, String email_id, String password, long phone_number) {
		super();
		this.admin_id = admin_id;
		this.email_id = email_id;
		this.password = password;
		this.phone_number = phone_number;
	}
	public int getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", email_id=" + email_id + ", password=" + password + ", phone_number="
				+ phone_number + "]";
	}
	
	
}
