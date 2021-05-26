package com.mph.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity(name = "BOOKING_HMS")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookingseq")
	@SequenceGenerator(name = "bookingseq", sequenceName = "bookingseq", initialValue = 50, allocationSize = 100)
	private int booking_id;
	
	@NotNull
	private Date booking_date;
	
	@NotNull
	private Date check_in;
	
	private Date check_out;
	
	@OneToOne
	@JoinColumn(name = "user_name", referencedColumnName = "USER_NAME")
	private User user;

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Booking(int booking_id, Date booking_date, Date check_in, Date check_out, User user) {
		super();
		this.booking_id = booking_id;
		this.booking_date = booking_date;
		this.check_in = check_in;
		this.check_out = check_out;
		this.user = user;
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

	public User getUser() {
		return user;
	}

	public void setUser_name(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Booking [booking_id=" + booking_id + ", booking_date=" + booking_date + ", check_in=" + check_in
				+ ", check_out=" + check_out + ", user_name=" + user + "]";
	}
	
	
	
}
