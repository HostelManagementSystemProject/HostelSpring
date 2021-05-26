package com.mph.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity(name = "ADMIN_HMS")
public class Admin {
	
	/**
	 * The admin Id
	 */
	@Id
	private int admin_id;
	
	/**
	 * The admin email Id
	 */
	@NotNull(message = "Email Id cannot be Null")
	private String email_id;
	
	/**
	 * The admin password
	 */
	@NotNull(message = "Password cannot be Null")
	@Size(min = 8, max = 12)
	private String password;

	/**
	 * The admin phone number
	 */
	@Size(min = 10, max = 10)
	private long phone_number;
	
	/**
	 * Instantiates a new address
	 */
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Instantiates a new address
	 * @param admin_id
	 * @param email_id
	 * @param password
	 * @param phone_number
	 */
	public Admin(int admin_id, String email_id, String password, long phone_number) {
		super();
		this.admin_id = admin_id;
		this.email_id = email_id;
		this.password = password;
		this.phone_number = phone_number;
	}
	
	/**
	 * gets the admin Id
	 * @return admin_id
	 */
	public int getAdmin_id() {
		return admin_id;
	}
	
	/**
	 * sets the admin Id
	 * @param admin_id
	 */
	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}
	
	/**
	 * gets the admin email Id
	 * @return email_id
	 */
	public String getEmail_id() {
		return email_id;
	}
	
	/**
	 * sets the email Id
	 * @param email_id
	 */
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	/**
	 * gets the password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	
	/**
	 * sets the password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * gets the phone number
	 * @return phone_number
	 */
	public long getPhone_number() {
		return phone_number;
	}
	
	/**
	 * sets the phone number
	 * @param phone_number
	 */
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", email_id=" + email_id + ", password=" + password + ", phone_number="
				+ phone_number + "]";
	}

}
