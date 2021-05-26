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

	private float salary;

	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Staff(int user_id, String user_name, Address address, long phone_number, String email_id, String password,
			String gender, Date date_of_birth, Room room) {
		super(user_id, user_name, address, phone_number, email_id, password, gender, date_of_birth, room);
		// TODO Auto-generated constructor stub
	}

	public Staff(float salary) {
		super();
		this.salary = salary;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Staff [salary=" + salary + "]";
	}

	

}
