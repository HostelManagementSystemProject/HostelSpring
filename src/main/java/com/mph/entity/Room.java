package com.mph.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="ROOM_HMS")
public class Room {
	@Id
	private int room_no;
	private String room_type;
	private int vacancy;
	private int total_rooms;
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "USER_ID")
	//@JoinColumn
	private User user;
	public Room() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Room(int room_no, String room_type, int vacancy, int total_rooms, User user) {
		super();
		this.room_no = room_no;
		this.room_type = room_type;
		this.vacancy = vacancy;
		this.total_rooms = total_rooms;
		this.user = user;
	}
	public int getRoom_no() {
		return room_no;
	}
	public void setRoom_no(int room_no) {
		this.room_no = room_no;
	}
	public String getRoom_type() {
		return room_type;
	}
	public void setRoom_type(String room_type) {
		this.room_type = room_type;
	}
	public int getVacancy() {
		return vacancy;
	}
	public void setVacancy(int vacancy) {
		this.vacancy = vacancy;
	}
	public int getTotal_rooms() {
		return total_rooms;
	}
	public void setTotal_rooms(int total_rooms) {
		this.total_rooms = total_rooms;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Room [room_no=" + room_no + ", room_type=" + room_type + ", vacancy=" + vacancy + ", total_rooms="
				+ total_rooms + ", user=" + user + "]";
	}
	
	
}
