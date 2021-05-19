package com.mph.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="BOOKING_HMS")
public class Booking {
	@Id
	private int booking_id;
	private Date booking_date;
	private Date check_in;
	private Date check_out;
	@ManyToOne(cascade=CascadeType.ALL)
	private Room room_no;
	@OneToOne(cascade=CascadeType.ALL)
	private User user_id;
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Booking(int booking_id, Date booking_date, Date check_in, Date check_out, Room room_no, User user_id) {
		super();
		this.booking_id = booking_id;
		this.booking_date = booking_date;
		this.check_in = check_in;
		this.check_out = check_out;
		this.room_no = room_no;
		this.user_id = user_id;
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public Date getBooking_date() {
		return booking_date;
	}
	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}
	public Date getCheck_in() {
		return check_in;
	}
	public void setCheck_in(Date check_in) {
		this.check_in = check_in;
	}
	public Date getCheck_out() {
		return check_out;
	}
	public void setCheck_out(Date check_out) {
		this.check_out = check_out;
	}
	public Room getRoom_no() {
		return room_no;
	}
	public void setRoom_no(Room room_no) {
		this.room_no = room_no;
	}
	public User getUser_id() {
		return user_id;
	}
	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}
	@Override
	public String toString() {
		return "Booking [booking_id=" + booking_id + ", booking_date=" + booking_date + ", check_in=" + check_in
				+ ", check_out=" + check_out + ", room_no=" + room_no + ", user_id=" + user_id + "]";
	}
	
}
