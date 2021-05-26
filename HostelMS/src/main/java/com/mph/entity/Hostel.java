package com.mph.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity(name = "HOSTEL_HMS")
public class Hostel {
	
	
	/**
	 * The hostel Id
	 */
	@Id
	private int hostel_id;
	
	
	/**
	 * The hostel name
	 */
	private String hostel_name;
	
	
	/**
	 * The hostel address
	 */
	private String hostel_address;
	
	
	/**
	 * The phone number
	 */
	@Size(min = 10, max = 10)
	private long phone_number;
	
	
	/**
	 * Instantiates a new address
	 */
	public Hostel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Instantiates a new address
	 * @param hostel_id
	 * @param hostel_name
	 * @param hostel_address
	 * @param phone_number
	 */
	public Hostel(int hostel_id, String hostel_name, String hostel_address, long phone_number) {
		super();
		this.hostel_id = hostel_id;
		this.hostel_name = hostel_name;
		this.hostel_address = hostel_address;
		this.phone_number = phone_number;
	}
	
	
	/**
	 * gets the hostel_id
	 * @return hostel_id
	 */
	public int getHostel_id() {
		return hostel_id;
	}
	
	/**
	 * sets the hostel_id
	 * @param hostel_id
	 */
	public void setHostel_id(int hostel_id) {
		this.hostel_id = hostel_id;
	}
	
	
	/**
	 * gets the hostel_name
	 * @return hostel_name
	 */
	public String getHostel_name() {
		return hostel_name;
	}
	
	
	/**
	 * sets the hostel_name
	 * @param hostel_name
	 */
	public void setHostel_name(String hostel_name) {
		this.hostel_name = hostel_name;
	}
	
	
	/**
	 * gets the hostel_address
	 * @return hostel_address
	 */
	public String getHostel_address() {
		return hostel_address;
	}
	
	
	/**
	 * sets the hostel_address
	 * @param hostel_address
	 */
	public void setHostel_address(String hostel_address) {
		this.hostel_address = hostel_address;
	}
	
	
	/**
	 * gets the phone_number
	 * @return phone_number
	 */
	public long getPhone_number() {
		return phone_number;
	}
	
	
	/**
	 * gets the phone_number
	 * @param phone_number
	 */
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}

	@Override
	public String toString() {
		return "Hostel [hostel_id=" + hostel_id + ", hostel_name=" + hostel_name + ", hostel_address=" + hostel_address
				+ ", phone_number=" + phone_number + "]";
	}

}
