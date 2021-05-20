package com.mph.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="HOSTEL_HMS")
public class Hostel {
	@Id
	private int hostel_id;
	private String hostel_name;
	private String hostel_address;
	private long phone_number;
	public Hostel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hostel(int hostel_id, String hostel_name, String hostel_address, long phone_number) {
		super();
		this.hostel_id = hostel_id;
		this.hostel_name = hostel_name;
		this.hostel_address = hostel_address;
		this.phone_number = phone_number;
	}
	public int getHostel_id() {
		return hostel_id;
	}
	public void setHostel_id(int hostel_id) {
		this.hostel_id = hostel_id;
	}
	public String getHostel_name() {
		return hostel_name;
	}
	public void setHostel_name(String hostel_name) {
		this.hostel_name = hostel_name;
	}
	public String getHostel_address() {
		return hostel_address;
	}
	public void setHostel_address(String hostel_address) {
		this.hostel_address = hostel_address;
	}
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
	}
	@Override
	public String toString() {
		return "Hostel [hostel_id=" + hostel_id + ", hostel_name=" + hostel_name + ", hostel_address=" + hostel_address
				+ ", phone_number=" + phone_number + "]";
	}
	
	
}
