package com.mph.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "ROOM_HMS")
public class Room implements Comparable<Room>{
	
	
	/**
	 * The room number
	 */
	@Id
	private int room_no;
	
	
	/**
	 * The room type
	 */
	@NotNull
	private String room_type;
	
	
	/**
	 * The vacancy
	 */
	private int vacancy;
	
	
	/**
	 * The total number of rooms
	 */
	private int total_rooms;


	/**
	 * Instantiates a new address
	 */
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Instantiates a new address
	 * @param room_no
	 * @param room_type
	 * @param vacancy
	 * @param total_rooms
	 */
	public Room(int room_no, String room_type, int vacancy, int total_rooms) {
		super();
		this.room_no = room_no;
		this.room_type = room_type;
		this.vacancy = vacancy;
		this.total_rooms = total_rooms;
		
	}
	
	
	/**
	 * gets the room_no
	 * @return room_no
	 */
	public int getRoom_no() {
		return room_no;
	}
	
	
	/**
	 * sets the room_no
	 * @param room_no
	 */
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	
	/**
	 * gets the room_type
	 * @return room_type
	 */
	public String getRoom_type() {
		return room_type;
	}
	
	
	/**
	 * sets the room_type
	 * @param room_type
	 */
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	
	
	/**
	 * gets the vacancy
	 * @return vacancy
	 */
	public int getVacancy() {
		return vacancy;
	}
	
	
	/**
	 * sets the vacancy
	 * @param vacancy
	 */
	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}
	
	
	/**
	 * gets the total_rooms
	 * @return total_rooms
	 */
	public int getTotal_rooms() {
		return total_rooms;
	}
	
	
	/**
	 * sets the total_rooms
	 * @param total_rooms
	 */
	public void setTotal_rooms(int total_rooms) {
		this.total_rooms = total_rooms;
	}


	@Override
	public int compareTo(Room room) {
		return(this.room_no-room.room_no);
	}
	
	@Override
	public String toString() {
		return "Room [room_no=" + room_no + ", room_type=" + room_type + ", vacancy=" + vacancy + ", total_rooms="
				+ total_rooms + "]";
	}

}
