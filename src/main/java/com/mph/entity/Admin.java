package com.mph.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity(name="ADMIN_HMS")
public class Admin extends User{

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Admin(int user_id, String user_name, Address address, long phone_number, String email_id, String password,
			String gender, Date date_of_birth, List<Room> room) {
		super(user_id, user_name, address, phone_number, email_id, password, gender, date_of_birth, room);
		// TODO Auto-generated constructor stub
	}

	
}
