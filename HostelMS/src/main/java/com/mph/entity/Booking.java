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
	
	
	/**
	 * The booking id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bookingseq")
	@SequenceGenerator(name = "bookingseq", sequenceName = "bookingseq", initialValue = 50, allocationSize = 100)
	private int booking_id;
	
	
	/**
	 * The booking date
	 */
	@NotNull
	private Date booking_date;
	
	
	/**
	 * The check in date
	 */
	@NotNull
	private Date check_in;
	
	
	/**
	 * The check out date
	 */
	private Date check_out;
	
	
	/**
	 * The user
	 */
	@OneToOne
	@JoinColumn(name = "user_name", referencedColumnName = "USER_NAME")
	private User user;
	
	
	/**
	 * Instantiates a new address
	 */
	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	/**
	 * Instantiates a new address
	 * @param booking_id
	 * @param booking_date
	 * @param check_in
	 * @param check_out
	 * @param user
	 */
	public Booking(int booking_id, Date booking_date, Date check_in, Date check_out, User user) {
		super();
		this.booking_id = booking_id;
		this.booking_date = booking_date;
		this.check_in = check_in;
		this.check_out = check_out;
		this.user = user;
	}
	
	
	/**
	 * gets the booking_id
	 * @return booking_id
	 */
	public int getBooking_id() {
		return booking_id;
	}
	
	
	/**
	 * sets the booking_id
	 * @param booking_id
	 */
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	
	
	/**
	 * gets the booking_date
	 * @return booking_date
	 */
	public Date getBooking_date() {
		return booking_date;
	}
	
	
	/**
	 * sets the booking_date
	 * @param booking_date
	 */
	public void setBooking_date(Date booking_date) {
		this.booking_date = booking_date;
	}
	
	
	/**
	 * gets the check_in date
	 * @return check_in
	 */
	public Date getCheck_in() {
		return check_in;
	}
	
	
	/**
	 * sets the check_in date
	 * @param check_in
	 */
	public void setCheck_in(Date check_in) {
		this.check_in = check_in;
	}
	
	
	/**
	 * gets the check_out date
	 * @return check_out
	 */
	public Date getCheck_out() {
		return check_out;
	}
	
	
	/**
	 * sets the check_out date
	 * @param check_out
	 */
	public void setCheck_out(Date check_out) {
		this.check_out = check_out;
	}
	
	
	/**
	 * gets the user
	 * @return user
	 */
	public User getUser() {
		return user;
	}
	
	
	/**
	 * sets the user
	 * @param user
	 */
	public void setUser_name(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Booking [booking_id=" + booking_id + ", booking_date=" + booking_date + ", check_in=" + check_in
				+ ", check_out=" + check_out + ", user_name=" + user + "]";
	}
	
	
	
}
