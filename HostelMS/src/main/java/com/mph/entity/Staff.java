package com.mph.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="STAFF_HMS")
public class Staff{
	@Id
	private int staff_id;
	private String staff_name;
	@Embedded
	/*@AttributeOverrides(value = {
	        @AttributeOverride(name = "addressLine1", column = @Column(name = "house_number")),
	        @AttributeOverride(name = "addressLine2", column = @Column(name = "street"))
	    })*/
	private Address address;
	private long phone_number;
	private String email_id;
	private String password;
	private String gender;
	private Date date_of_birth;
	private float salary;
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Staff(int staff_id, String staff_name, Address address, long phone_number, String email_id, String password,
			String gender, Date date_of_birth, float salary) {
		super();
		this.staff_id = staff_id;
		this.staff_name = staff_name;
		this.address = address;
		this.phone_number = phone_number;
		this.email_id = email_id;
		this.password = password;
		this.gender = gender;
		this.date_of_birth = date_of_birth;
		this.salary = salary;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public long getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(long phone_number) {
		this.phone_number = phone_number;
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
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Staff [staff_id=" + staff_id + ", staff_name=" + staff_name + ", address=" + address + ", phone_number="
				+ phone_number + ", email_id=" + email_id + ", password=" + password + ", gender=" + gender
				+ ", date_of_birth=" + date_of_birth + ", salary=" + salary + "]";
	}
	
	
}
