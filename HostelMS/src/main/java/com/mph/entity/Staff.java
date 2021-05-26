package com.mph.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "STAFF_HMS")
public class Staff extends User{
	
	
	/**
	 * The salary
	 */
	private float salary;
	
	
	/**
	 * Instantiates a new address
	 */
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Instantiates a new address
	 * @param user_id
	 * @param user_name
	 * @param address
	 * @param phone_number
	 * @param email_id
	 * @param password
	 * @param gender
	 * @param date_of_birth
	 * @param room
	 */
	public Staff(int user_id, String user_name, Address address, long phone_number, String email_id, String password,
			String gender, Date date_of_birth, Room room) {
		super(user_id, user_name, address, phone_number, email_id, password, gender, date_of_birth, room);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Instantiates a new address
	 * @param salary
	 */
	public Staff(float salary) {
		super();
		this.salary = salary;
	}
	
	
	/**
	 * gets the salary
	 * @return salary
	 */
	public float getSalary() {
		return salary;
	}
	
	
	/**
	 * sets the salary
	 * @param salary
	 */
	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Staff [salary=" + salary + "]";
	}

	

}
