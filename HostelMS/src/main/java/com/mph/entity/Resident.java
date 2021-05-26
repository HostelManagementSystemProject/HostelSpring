package com.mph.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;

@Entity(name="RESIDENT_HMS")
public class Resident extends User{
	
	/**
	 * The food preferences
	 */
	private String food_preferences;
	
	
	/**
	 * Instantiates a new address
	 */
	public Resident() {
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
	public Resident(int user_id, String user_name, Address address, long phone_number, String email_id, String password,
			String gender, Date date_of_birth, Room room) {
		super(user_id, user_name, address, phone_number, email_id, password, gender, date_of_birth, room);
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Instantiates a new address
	 * @param food_preferences
	 */
	public Resident(String food_preferences) {
		super();
		this.food_preferences = food_preferences;
	}
	
	
	/**
	 * gets the food_preferences
	 * @return food_preferences
	 */
	public String getFood_preferences() {
		return food_preferences;
	}
	
	
	/**
	 * sets the food_preferences
	 * @param food_preferences
	 */
	public void setFood_preferences(String food_preferences) {
		this.food_preferences = food_preferences;
	}

	@Override
	public String toString() {
		return "Resident [food_preferences=" + food_preferences + "]";
	}

	
	
}
